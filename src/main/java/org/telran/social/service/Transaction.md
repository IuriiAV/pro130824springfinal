

@Transactional -> Proxy для класса , внутри этого класса
менеджер транзакций устанавливает коннект к базе данных
и устанавливает признак setAutoCommit false
Далее в этом прокси классе вызвается метод нашего оригинального
класса, который был помечен как @transactional и если он выполнился
успешно, то менеджер транзакций делает commit иначе rollback

class MessageServiceImplProxy implements MessageService{

   private MessageServiceImpl messageService;

   public void sendMessage(String message, Long from, Long to) {
          txManager.setAutoCommit(false);
          try{
                messageService.sendMessage( message, from,to);
                txManager.commit();
            } catch(Excpetion e) {
                txManager.rollback();
            }
    }

}