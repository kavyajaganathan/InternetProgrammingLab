<%@ page import="java.util.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
    <h1>eCommerce</h1>
    <h2> <%= "Welcome " + (String)request.getAttribute("name") %> </h2>

    <h4>Cart:</h4>
    <div>
        Total: <em><strong id="totalE">0</strong></em>
        <ul id="cartE">
        </ul>
    </div>

    <br><br>
    <h4>Products:</h4>
    <ul>
        <li>
            <div class="itemE" id="item1">
                <strong>Soap</strong>
                <em>$</em><em>10</em>
                <button onclick="addtocart(this)">Add</button>
            </div>
        </li>

        <li>
            <div class="itemE" id="item2">
                <strong>Apples</strong>
                <em>$</em><em>5</em>
                <button onclick="addtocart(this)">Add</button>
            </div>
        </li>

        <li>
            <div class="itemE" id="item3">
                <strong>Handwash</strong>
                <em>$</em><em>12</em>
                <button onclick="addtocart(this)">Add</button>
            </div>
        </li>
    </ul>

    <form method="GET" action="deletecookie">
        <input type="submit" value="Clear Cookies">
    </form>

    <%
        Cookie cookie = null;
        Cookie[] cookies = null;

        String totalKey = "total";
        String totalValue = "NULL";
        String soapKey = "soap";
        String soapValue = "NULL";
        String applesKey = "apples";
        String applesValue = "NULL";
        String handwashKey = "handwash";
        String handwashValue = "NULL";

        cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (totalKey.equals(cookie.getName())) {
                    totalValue = cookie.getValue();
                }
                if (soapKey.equals(cookie.getName())) {
                    soapValue = cookie.getValue();
                }
                if (applesKey.equals(cookie.getName())) {
                    applesValue = cookie.getValue();
                }
                if (handwashKey.equals(cookie.getName())) {
                    handwashValue = cookie.getValue();
                }
            }
        } else {
            out.println("<h2>No Cookies!</h2>");
        }
    %>

    <script>
        var total = 0;
        var cartList = {
            Soap: 0,
            Apples: 0,
            Handwash: 0,
        };
        var totalString = "<%out.print(totalValue);%>";
        var soapString = "<%out.print(soapValue);%>";
        var applesString = "<%out.print(applesValue);%>";
        var handwashString = "<%out.print(handwashValue);%>";
        if(totalString !== "NULL") {
            total = Number(totalString);
        }
        if(soapString !== "NULL") {
            cartList["Soap"] = Number(soapString);
        }
        if(applesString !== "NULL") {
            cartList["Apples"] = Number(applesString);
        }
        if(handwashString !== "NULL") {
            cartList["Handwash"] = Number(handwashString);
        }
        renderCart();
        function addtocart(thisbutton) {
            var value = parseInt(thisbutton.parentElement.children[2].innerText);
            total += value;
            cartList[thisbutton.parentElement.children[0].innerText] += 1;
            renderCart();
        }
        function renderCart() {
            htmlString = "";
            paramString = "";
            paramString += "?total="+total.toString();

            if(cartList["Soap"]!==0){
                var val = cartList["Soap"].toString();
                htmlString += `<li>Soap: <strong>`+ val +`</strong> </li>`;
                paramString+="&soap="+val;
            }
            if (cartList["Apples"] !== 0) {
                var val = cartList["Apples"].toString();
                htmlString += `<li>Apples: <strong>` + val +`</strong> </li>`
                paramString+="&apples="+val;
            }
            if (cartList["Handwash"] !== 0) {
                var val = cartList["Handwash"].toString();
                htmlString += `<li>Handwash: <strong>` + val +`</strong> </li>`
                paramString+="&handwash="+val;
            }
            var http = new XMLHttpRequest();
            var url = '/shopapp/data';
            http.open('GET', url+paramString, true);
            http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            http.onreadystatechange = function() {
                if(http.readyState == 4 && http.status == 200) {
                    console.log(http.responseText);
                }
            }
            http.send();
            totalE.innerText = total.toString();
            cartE.innerHTML = htmlString;
        }
    </script>
</body>
</html>
