function isEmpty(strfield1) {
    
    val = strfield1.value;
    
    if(isNaN(val) || val == "" || val == null || val.charAt(0) == ' ') {
        alert("No or Wrong input\nPlease try again!!");
        return true;
    }
    
    return false;
}

function check(form) {
    
    if(isEmpty(form.amount1)) {
        return false;
    }
    
    return true;
}