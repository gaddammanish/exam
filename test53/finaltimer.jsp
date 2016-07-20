<html>
<head>
    <title></title>
    <script language ="javascript" >
        var tim;
        var x;
        var y;
        var flag=1;
        var min = 0;
        var sec = 10;
        <% ServletContext context=pageContext.getServletContext();%>
        function f2() 
 {
            if (parseInt(sec) > 0 && flag == 1) 
     {
                if(document.getElementById("three").checked == true)
                {
                    flag = 0;
                }
                if(document.getElementById("four").checked == true)
                {
                    flag = 0;
                }
               
                document.getElementById("showtime").innerHTML = "Time Left:"+min+" Minutes ," + sec+" Seconds";
                sec = parseInt(sec) - 1;
                tim = setTimeout("f2()", 1000);
            }
            else 
     {
               if(document.getElementById("three").checked == true)
                {
                    flag = 0;
                }
                if(document.getElementById("four").checked == true)
                {
                    flag = 0;
                }
                if (parseInt(sec) == 0 ) 
                {
                     document.forms["apple"].submit();
                    
                }
                     
                document.getElementById("showtime").innerHTML = "Time Left:"+min+" Minutes ," + sec+" Seconds";
                sec = parseInt(sec) - 1;
                tim = setTimeout("f2()", 1000);
            
            }

        }
 function disableBackButton()
 {
  window.history.forward();
 }
 setTimeout("disableBackButton()", 0);
    </script>
</head>
<body onload="f2()" onunload="disableBackButton()" >
            <div id="showtime" align="right"></div> 
     <div id="endtime" align="right"></div>
<%= request.getAttribute("quest") %>
<form action="start" method="GET" name="apple">
<input type="radio" name="gender" id="three" value=<%= request.getAttribute("op1")%> ><%= request.getAttribute("op1")%><br>
<input type="radio" name="gender" id="four" value=<%= request.getAttribute("op2")%> > <%= request.getAttribute("op2")%><br>
<input type="submit" value="submit">
</form>
</body>
</html>