<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Change Customer</title>
</head>
    <body>
    <div>
        <fieldset>
            <legend>Change Customer</legend>
            Данные о клиенте с логиным ${customer.login} <br>
            First Name: ${customer.firstName} <br>
            Last Name: ${customer.lastName} <br>
            City: ${customer.city} <br>
            Age: ${customer.age} <br>
            <br>
            <#--<form name="customer" action="" method="POST">-->
                <#--Login: <@spring.formInput "customerForm.login" "" "text"/>    <br/>-->
                <#--Old Password: <@spring.formInput "customerForm.password" "" "text"/>    <br/>-->
                <#--New Password: <@spring.formInput "customerForm.newPassword" "" "text"/>    <br/>-->
                <#--City: <@spring.formInput "customerForm.city" "" "text"/>    <br/>-->
                <#--First Name: <@spring.formInput "customerForm.firstName" "" "text"/>    <br/>-->
                <#--Last Name: <@spring.formInput "customerForm.lastName" "" "text"/>    <br/>-->
                <#--Age: <@spring.formInput "customerForm.age" "" "text"/>    <br/>-->
                <#--<input type="submit" value="Изменить" />-->
                <#--<a href="<@spring.url '/customersList'/>">Все суещствующие клиенты</a>-->
            <#--</form>-->
        </fieldset>
    </div>
    </body>
</html>