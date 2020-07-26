  function createOrder(){
        var xmlhttp = new XMLHttpRequest();
        var baseurl = "http://localhost:8080/server";
        xmlhttp.open("GET",baseurl + "/order/SERVER_A/SERVER_A",true);
        xmlhttp.send();
        
        xmlhttp.onreadystatechange=(e)=>{
        	console.log(xmlhttp.responseText)
        }
        xmlhttp.onreadystatechange = function() {
          if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
            document.getElementById("servers").innerHTML = JSON.parse(xmlhttp.responseText);
          }
        };
        
      }