<#import "/spring.ftl" as spring/>

<html>
   <head>
      <title>Customer List of Postgres</title>
   </head>
   <body>
     <h3>Customer List of Postgres</h3>
     <a href="<@spring.url '/addCustomer'/>">Add Customer</a>
     <br><br>
      <div>
         <table border="1">
            <tr>
               <th>Login</th>
               <th>City</th>
            </tr>
            <#list customers as customer>
            <tr>
               <td>${customer.login}</td>
               <td>${customer.city}</td>
            </tr>
            </#list>
         </table>
      </div>
   </body>
</html>