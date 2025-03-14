Social network :
1) User - NetworkUser





DB ->jdbc driver(impl) ->jdbc template(impl) ->
-> JPA (interface) -> impl Hibernate framework (фреймфорк, реализующий стандарт JPA)(jdbc inside)
                   -> impl other framework

ORM - Object relational mapping  -> Java class <-> DB Table (fields in class <-> column table)


2) User -> Posts
3) get User, get user posts, delete user and delete his post 
4) get all users

SQL:
network_user (id,....)
posts(id,...., network_user_id)

Java:
OneToMany (выборку всех связных постов, когда читаем юзера)

NetworkUser :
    id.....
    
    OneToMany
    List<Post> post

Post :
    id
    ...

Если хотим получить посты пользователя, то теперь можно просто выбрать пользователя

Но при этом получить пользователя без постов нельзя(а нам надо без)
Fetch.LAZY - позволяет выбрать из базы данных только пользователя

Для получения всех постов пользователя, мы может в репозитории постов сделать метод
для этого отдельный и все будет хорошо