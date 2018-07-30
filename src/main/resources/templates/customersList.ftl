<#import "/spring.ftl" as spring/>

<html>
   <head>
      <title>Customer List of Postgres</title>
   </head>
   <body>
     <a href="<@spring.url '/addCustomer'/>">Добавить клиента</a>

     <@spring.bind "loginForm"/>
     <form method="POST">
     Login:
         <@spring.formInput "loginForm.login"/>
         <@spring.showErrors ","/> <br>
     </form>
     <br>
      <div>
         <table border="1">
             <h3>Список клиентов по базе данных PostgreSQL</h3>
            <tr>
                <th>Login</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>City</th>
                <th>Age</th>
            </tr>
            <#list customers as customer>
            <tr>
                <td>${customer.login}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.city}</td>
                <td>${customer.age}</td>
            </tr>
            </#list>
         </table>
      </div>
   </body>
</html>