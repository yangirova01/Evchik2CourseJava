<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,300;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/home.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script>
        function rendering(products, container){
            let innerHTML = '<div class=\"row\">';
            console.log(11111);
            console.log(innerHTML);
            for (let i = 0; i < products.length; i++) {
                innerHTML += '<div class=\"products\">';
                innerHTML += '<h2 id=\"products-name\" class=\"shrift\" style=\"font-size: 20px\">'+ products[i]['name']+'</h2>';
                innerHTML += '<p id=\"products-price\" class=\"shrift\">'+'ЦЕНА: '+ products[i]['price']+'</p>';
                innerHTML += '<p id=\"products-size\" class=\"shrift\">'+'РАЗМЕР:'+ products[i]['size']+'</p>';
                innerHTML += '<form action=\"/basket?id=' + products[i]['id'] + '\" method=\"post\"><button type=\"submit\" class=\"test mybtn\" id=\"btnBuy\">В КОРЗИНУ</button></form>';
                console.log(innerHTML);
            }

            innerHTML += '</div>';
            container.html(innerHTML);
        }
        function showProducts() {
            let data = {
                "price" : $('#price').val(),
                "size" : $('#size').val()[0]
            };

            console.log($('#price').val());
            console.log($('#size').val()[0]);
            $.ajax({
                type: "POST",
                url: "/products",
                data: JSON.stringify(data),
                success: function (response){
                    rendering(response, $('#products'))
                },
                dataType: "json",
                contentType: "application/json",
                encoding: "UTF-8"
            });
        }
    </script>
</head>
<body>
<div class="marquee shrift"><span>Скидки до 50% на осеннюю коллекцию!</span></div>
<div class="main">
    <nav class="navbar navbar-expand-lg navbar-light bg-white ">
        <a class="navbar-brand " href="/home">
            <h1>Calvin Klein</h1>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto ">
                <li class="nav-item active shrift ">
                    <form action="/products" method="post">
                        <a class="nav-link " href="/products">ПРОДУКТЫ</a>
                    </form>
                </li>
            </ul>
        </div>

        <form>
            <input type="text" class="shrift input" placeholder="ПОИСК">
            <button type="submit" class="shrift">ИСКАТЬ</button>
        </form>
        <form action="/signUp" method="get">
            <button type="submit" class="shrift signUp" style="color: black" data-toggle="modal"
                    data-target="#exampleModalSignUp" href="/signUp">ЗАРЕГИСТРИРОВАТЬСЯ
            </button>
        </form>
        <form action="/signIn" method="post">
            <button type="submit" class="shrift signIn" style="color: black" data-toggle="modal"
                    data-target="#exampleModal" href="/signIn">ВОЙТИ</button>
        </form>
        <form action="/basket" method="get">
            <button class="logo" style="background-color:white">
                <svg width="2em" height="2em" viewBox="0 0 20 20" fill="black" xmlns="http://www.w3.org/2000/svg"
                     href="/basket">
                    <path fill-rule="evenodd"
                          d="M8 1a2.5 2.5 0 0 0-2.5 2.5V4h5v-.5A2.5 2.5 0 0 0 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5H2z"/>
                </svg>
            </button>
        </form>
        <form action="/profil" method="post">
            <button style="background-color:white">
                <svg width="2em" height="2em" viewBox="0 0 18 18" fill="black" xmlns="http://www.w3.org/2000/svg"
                     href="/profil">
                    <path fill-rule="evenodd"
                          d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                </svg>
            </button>
        </form>
    </nav>
    <div class="category catside">
        <a class="categoryall" href="#">НОВИНКИ</a>
        <a class="categoryall" href="#">НИЖНЕЕ БЕЛЬЕ</a>
        <a class="categoryall" href="#">ОДЕЖДА</a>
        <a class="categoryall" href="#">СУМКИ И АКСЕССУАРЫ</a>
        <a class="categoryall" href="#">ОБУВЬ</a>
        <a class="categoryall" href="#">ПОДАРКИ</a>
    </div>
    <hr>
    <h2 class="shrift" style="margin-left:50%">ПРОДУКТЫ</h2>
    <input id="price" type="text" onkeyup="showProducts()" class="gdg" placeholder="ЦЕНА">
    <select size="5" multiple name="size" id="size" onclick="showProducts()">
        <option selected value="XS">XS</option>
        <option value="S">S</option>
        <option value="M">M</option>
        <option value="L">L</option>
        <option value="XL">XL</option>
    </select>
    <div class = "products" id = "products">

    </div>
</div>

</div>
<footer class="shrift">
    <hr>
    <p style="margin-left: 50px">ПОДПИШИТЕСЬ НА РАССЫЛКУ И ПОЛУЧИТЕ СКИДКУ 10% НА ВАШ ЗАКАЗ</p>
    <p class="dop" style="margin-left: 50px">ОСТАВАЙТЕСЬ В КУРСЕ НАШИХ НОВОСТЕЙ И ПОЛУЧИТЕ СКИДКУ 10%</p>
    <div class="form-inline">
        <form action="/home" method="post">
            <input type="email" name="email" class="gdg" style="margin-left: 50px" placeholder="ВВЕДИТЕ ЭЛ.АДРЕС">
            <button  type="submit" class="test mybtn">ПОДПИШИТЕСЬ</button>
        </form>
    </div>
</footer>
</body>
</html>