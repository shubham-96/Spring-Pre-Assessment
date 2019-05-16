var customerRow = "<div id='customerId' class='customerContainer entry'><span class='entry'>customerName</span><span class='entry'>Score: customerScore</span><button class='remove'>Delete</button></div><br />";

$(document).ready(function() {
    removeCustomer();
    displayMyCustomers();
});

function addCustomer(){
        var name = document.getElementById("name");
        var score = document.getElementById("score");
        $.ajax({
            url: "/saveCustomer?name="+name+"&score="+score,
            method: 'POST',
            dataType: 'json',
            success: function(customer){

            },
            error: function(jqXHR, exception){
                if(jqXHR.status==500){
                    alert("Customer Already Added! Please Try Again. ");
                }
            }
        });
}

function removeCustomer() {
    $(document).on("click", ".remove", function(){
        var customerId = $(this).attr('id');
        $.ajax({
            url:"removeCustomer?userId=1+customerId="+customerId,
            method:'POST',
            dataType:'json',
            success:function(){}
        });
        $(this).parent().hide();
    });
}

function displayMyCustomers(){
    var $container = $("#customerList");
    $.ajax({
        url: "/customers?userId=1",
        method: 'GET',
        dataType: 'json',
        success: function(customersList){
            if (customersList.length != 0) {
                for (var i = 0; i < customersList.length; i++) {
                    addCustomer(customersList[i]);
                }
            } else {
                $container.append('<div class="noCustomers">No Customers found!</div>');
            }
        }
    });
}

function addCustomer(customer){
    var $container = $("#customerList");
    var replacedId = customerRow.replace(/customerId/g, customer.id);
    var replacedName =   replacedId.replace(/customerName/g,customer.name);
    //var replacedScore =  replacedName.replace(/customerScore/g,customer.score);
    $container.append(replacedName);
}