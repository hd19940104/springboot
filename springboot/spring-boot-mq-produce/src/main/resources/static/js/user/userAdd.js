function add(){
    $.post(
        "add01",
        {"username":"12","password":"12","age":"12"},
        function(response){
            if(response.success){
                alert(response.msg);
            }
        },
        "json"
    )
}