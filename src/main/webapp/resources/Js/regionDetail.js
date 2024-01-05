/**
 * 
 */
 
const del = document.getElementById("del");
const frm = document.getElementById("frm");
del.addEventListener("click", function(){
    let result = confirm("정말 삭제하시겠습니까?");
    if(result)
        frm.submit();
});

const up = document.getElementById("up");
up.addEventListener("click", function(event){
    // const regionId = event.target.getAttribute("data-region-id");

    frm.setAttribute("method" , "get");
    frm.setAttribute("action", "./update");

    // location.href=`./update?region_id=${regionId}`;

    frm.submit();
});