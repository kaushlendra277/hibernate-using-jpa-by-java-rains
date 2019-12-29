# hibernate-using-jpa-by-java-rains

### Printing Complete query and its place holder in console log
Add the below property to application.properties file
#### To show sql statement in th log/console
logging.level.org.hibernate.SQL=debug <br />
This is an alternative way of printing jpa qeries in console its counter part is **spring.jpa.show-sql=true** <br />

#### show sql values i.e. place holders for "?"
logging.level.org.hibernate.type.descriptor.sql=trace