<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
   </head>

   <body>
      <h1>Welcome</h1>

      <a href="<@spring.url '/customersList'/>">Все суещствующие клиенты</a>

   </body>

</html>