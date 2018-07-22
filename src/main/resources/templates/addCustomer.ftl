<#import "/spring.ftl" as spring/>

<html>
   <head>
      <title>Add Customer</title>
   </head>
   <body>
      <div>
         <fieldset>
            <legend>Add Customer</legend>
            <form name="customer" action="" method="POST">
               Login: <@spring.formInput "customerForm.login" "" "text"/>    <br/>
               Password: <@spring.formInput "customerForm.password" "" "text"/>    <br/>
               City: <@spring.formInput "customerForm.city" "" "text"/>    <br/>
               <input type="submit" value="Create" />
            </form>
         </fieldset>
      </div>


   </body>

</html>