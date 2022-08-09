      </table>
        <table border="1" cellspacing="0" cellpadding="1">
            <tr> <span class="label">${uiLabelMap.CommonUsername}</span><br><br>
            <#if UserLogin?has_content>
             ${UserLogin.userLoginId!}
        </#if>
       </table>
