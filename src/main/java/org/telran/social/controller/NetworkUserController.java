package org.telran.social.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.telran.social.dto.NetworkUserRequestDto;
import org.telran.social.dto.NetworkUserResponseDto;
import org.telran.social.entity.NetworkUser;
import org.telran.social.security.AuthenticationService;
import org.telran.social.security.model.SignInRequest;
import org.telran.social.security.model.SignInResponse;
import org.telran.social.service.Converter;
import org.telran.social.service.NetworkUserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CRUD - create, read, update ,delete
 *
 * @RestController = @Controller + @ResponseBody
 * @ResponseBody - означает, что можно возвращать объекты из методов контроллера
 * и они будут преобразованы в нашем случае в JSON формат
 * <p>
 * Наше веб приложение доступно по адресу http://localhost:8080/
 * WEB -> DispatcherServlet (распределяет входящие запросы по контроллерам)
 * для выбора нужного контроллера исползуем @RequestMapping
 * После добавления вот этой аннотации @RequestMapping("/api/users")
 * наш контроллер доступен по адресу :
 * http://localhost:8080/api/users
 * <p>
 * REST API :
 * GET  http://localhost:8080/api/users - get all users
 * GET  http://localhost:8080/api/users/12 - get user by id = 12
 * POST http://localhost:8080/api/users - create user
 * DELETE http://localhost:8080/api/users/23 - delete user by id = 23
 * @PathVariable - когда параметр является частью url
 * <p>
 * Путь до конкретного меда контроллера складывается из
 * Имя хоста : localhost
 * Номер порта : 8080
 * Адрес контроллера (@RequestMapping) : /api/users
 * Адрес метода (@GetMapping,@PostMapping etc) :
 * <p>
 * JSON - JavaScript object notation (human readable)
 * XML
 * <p>
 * FROM WEB to SERVER -> JSON -> convert to Java Object - jackson lib.
 * FROM SERVER to WEB -> Java Object -> convert to JSON - jackson lib.
 * <p>
 * DTO - data transfer object :
 * getById -> NetworkUser(id,name,surname,login,password) -> convert to DTO ->
 * -> NetworkUserResponseDto(id, name, surname) -> convert to JSON -> REST
 * <p>
 * JSON(name,surname,login) -> convert to NetworkUserRequestDto(name,surname,login) ->
 * service -> NetworkUserRequestDto -> NetworkUser
 */

@RestController
@RequestMapping("/api/users")
public class NetworkUserController {

    private static final Logger log = LoggerFactory.getLogger(NetworkUserController.class);

    @Autowired
    private Converter<NetworkUserRequestDto, NetworkUserResponseDto, NetworkUser> converter;

    @Autowired
    private NetworkUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    // GET http://localhost:8080/api/users
    @GetMapping // - GET запрос
    public List<NetworkUserResponseDto> getAll() {
        return userService.getAll()
                .stream()
                .map(user -> converter.toDto(user))
                .collect(Collectors.toList());
    }

    //1. Передача параметра в метод как часть адреса @PathVariable
    //GET http://localhost:8080/api/users/12
    @GetMapping("/{id}")
    public NetworkUser getById(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

    //POST http://localhost:8080/api/users
    //2. Передача параметра в метод в теле запроса @RequestBody

    //Всегда, когда что-то создаем в системе, если все хорошо, то возвращаем 201 код
    @PostMapping // - POST запрос
    @ResponseStatus(HttpStatus.CREATED)
    public NetworkUserResponseDto create(@RequestBody NetworkUserRequestDto requestDto) {
        String encoded = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(encoded);
        NetworkUser networkUser = userService.create(converter.toEntity(requestDto));
        return converter.toDto(networkUser);
    }

    @PostMapping("/login")
    public SignInResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }

    //GET http://localhost:8080/api/users/filter?minAge=18&maxAge=35
    //3. Передача параметра в метод как параметры запроса(через адресную строку) @RequestParam
    @GetMapping("/filter")
    public List<NetworkUser> filter(@RequestParam(name = "minAge", required = false) Long minAge,
                                    @RequestParam(name = "maxAge", required = false) Long maxAge) {
        return userService.filter(minAge, maxAge);
    }

    //DELETE http://localhost:8080/api/users/23
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/generate")
    public void generatePostForUser() {
        userService.generatePost(6L);
    }
}
