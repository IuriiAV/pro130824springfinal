Social network :
1) User - NetworkUser





DB ->jdbc driver(impl) ->jdbc template(impl) ->
-> JPA (interface) -> impl Hibernate framework (фреймфорк, реализующий стандарт JPA)(jdbc inside)
                   -> impl other framework

ORM - Object relational mapping  -> Java class <-> DB Table (fields in class <-> column table)