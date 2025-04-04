MailService :
User -> id, name, List<Email> emails (id is email)
10 users

MailDistributor :

1) get email (from ALLEmails)
2) find receiver (user by email)
3) put email to receiver inbox (add to user email list)

CheckEmail : 
1) Find new email in inbox
2) Send notification -> log

Map<email, user>

file on disk 
 email -> text
 email -> text

put in common list(AllEmails)

