
function funcSelect(a) {
    let inp = a.value;
    if (inp == "add") {
        document.querySelector("#block_add").style.display='block';
        document.querySelector("#block_update").style.display='none';
		document.querySelector("#block_remove").style.display='none';
    } else if (inp == "update") {
        document.querySelector("#block_add").style.display='none';
        document.querySelector("#block_update").style.display='block';
		document.querySelector("#block_remove").style.display='none';  
    } else if (inp == "remove") {
        document.querySelector("#block_add").style.display='none';
        document.querySelector("#block_update").style.display='none';
		document.querySelector("#block_remove").style.display='block';
    }         
}