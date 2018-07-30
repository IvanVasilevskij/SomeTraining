<#import "/spring.ftl" as spring/>

<html>
   <head>
      <title>Add Customer</title>
   </head>
<body>
   <div>
      <fieldset>
         <legend>Add Customer</legend>
            <@spring.bind "customerForm"/>
                <form action="" method="POST">
                    Login:
                   <@spring.formInput "customerForm.login"/>
                   <@spring.showErrors ","/> <br>
                    Password:
                   <@spring.formInput "customerForm.password"/>
                   <@spring.showErrors ","/> <br>
                    City:
                   <@spring.formInput "customerForm.city"/>
                   <@spring.showErrors ","/> <br>
                    <br>
                    <input type="submit" value="Создать">
                </form>
      </fieldset>
   </div>


</body>

</html>