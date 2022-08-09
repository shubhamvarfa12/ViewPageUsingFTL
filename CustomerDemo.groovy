import java.lang.*
import java.util.*
import org.apache.ofbiz.base.util.*
import org.apache.ofbiz.entity.*
import org.apache.ofbiz.entity.util.*
import org.apache.ofbiz.entity.condition.*
import org.apache.ofbiz.party.contact.ContactMechWorker
import org.apache.ofbiz.product.store.ProductStoreWorker
import org.apache.ofbiz.accounting.payment.PaymentWorker

partyId=parameters.PartyId

Party = from("Person").where("partyId",partyId).queryOne()
context.Party1 = Party
print("========0000000000000000=============="+Party)

ContactMechs = from("PartyContactMech").where("partyId",partyId).queryList();
print("===========11111111111111======"+ContactMechs)

postalAddresses = []
telecomNumbers = []
emailAddresses = []
//partyContactMechPurposes = []
if (ContactMechs) {
    for (ContactMech in ContactMechs) {
        contactmid = ContactMech.get("contactMechId");
        partyContactMechPurpose = from("PartyContactMechPurpose").where("partyId",partyId, "contactMechId",contactmid).queryFirst();

        if(partyContactMechPurpose != null) {
            contactMechId = from("ContactMech").where("contactMechId", ContactMech.contactMechId).queryFirst()
            emailAddresses.add(contactMechId)
        }
        if(partyContactMechPurpose != null) {
        PostalAddress = from("PostalAddress").where("contactMechId", contactmid).queryFirst();
        postalAddresses.add(PostalAddress)
        }
        if(partyContactMechPurpose != null) {
            telecomNumber = from("TelecomNumber").where("contactMechId",contactmid).queryFirst();
        telecomNumbers.add(telecomNumber) }
    }
}
context.postalAddresses=postalAddresses
context.telecomNumbers = telecomNumbers
context.emailAddresses = emailAddresses

PartyContactMechs = from("PartyContactMech").where("partyId",partyId).queryIterator();
category = null
telecomNumbers1 = []
while ((PartyContactMech = (GenericValue) PartyContactMechs.next())) {
    contactmid1 =  PartyContactMech.getString("contactMechId")
    telecomNumber1 = from("TelecomNumber").where("contactMechId",contactmid1).queryFirst();
    telecomNumbers1.add(telecomNumber1)
}
context.telecomNumbers1 = telecomNumbers1
PartyContactMechs.close()

PaymentMethod = from("PaymentMethod").where("partyId",partyId).queryFirst();
print("======================66666666666666================="+PaymentMethod)

paymentMethId = PaymentMethod.get("paymentMethodId");

CreditCard = from("CreditCard").where("paymentMethodId",paymentMethId).queryFirst();
context.CreditCard = CreditCard
print("======================7777777777777777777================="+CreditCard)

//---------------------------------------------------------------------------------------------------
UserLogin = from("UserLogin").where("partyId",partyId).queryFirst();
print("======================888888888888888888888================="+UserLogin)
cmid1 = UserLogin.get("userLoginId");
context.UserLogin = UserLogin


//
//if(partyContactMechPurpose != null) {
//    partyContactMechPurposeId = partyContactMechPurpose.get("contactMechPurposeTypeId");
//    partyContactMechPurposes.add(partyContactMechPurposeId)
//}
//    println "====PartyContactMech class==="+PartyContactMech.getClass()
//    println "===PartyContactMech===getstring=="+PartyContactMech.getString("contactMechId");
//    println "=======PartyContactMech.contactMechId=="+PartyContactMech.contactMechId;