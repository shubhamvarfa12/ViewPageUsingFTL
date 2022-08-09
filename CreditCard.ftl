  </table>
        <table border="1" cellspacing="0" cellpadding="1">
            <tr> <span class="label">${uiLabelMap.PartyCreditCard}</span>
            <#if CreditCard?has_content>
                 ${CreditCard.firstNameOnCard!}
                 ${CreditCard.lastNameOnCard!} <br><br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                 ${CreditCard.cardType!}
                 ${CreditCard.cardNumber!}
                 ${CreditCard.expireDate!}
                (Updated: ${CreditCard.lastUpdatedStamp!})<br><br>
                </#if>
        </table>