      <div class="screenlet-body">
       <table border="1" cellspacing="0" cellpadding="1">
                <tr> <span class="label">${uiLabelMap.PartyName}</span>
                  <#if Party1?has_content>
                       ${Party1.personalTitle!}
                       ${Party1.firstName!}
                       ${Party1.middleName!}
                       ${Party1.lastName!}
                   </#if>
              </table>
          </div>