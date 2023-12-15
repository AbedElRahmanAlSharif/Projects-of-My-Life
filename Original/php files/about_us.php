<!DOCTYPE html>
<html>
    <head>
        <title>About Us</title>
        <link rel="stylesheet" href = "../css files/stylesheet_1.css"/>
        <link rel="stylesheet" href="../css files/about_us.css"/>
        <script type = "text/javascript" src = "../javascript files/script_1.js" defer></script>
    </head>
    <body>
        <!--Navigation Bar-->
        <div class="header">
            <form>
                <header>
                    <div class="name_logo">
                        <img src = "../resources/logos/logo.png" alt = "Solatrix Logo"/>
                        <h1>Solatrix</h1>
                    </div>
                    <nav class="large_screen">
                        <a class="nav_links" href="about_us.php" target="_parent">About Us</a> 
                        <a class="nav_links" href="products.php" target="_parent">Products</a> 
                        <a class="nav_links" href="services.php" target="_parent">Services</a> 
                        <a class="nav_links" href="projects.php" target="_parent">Projects</a> 
                    </nav>
                    <div class="reg_search large_screen">
                        <a href="register.html" target = "_blank"><ion-icon name="person-sharp" class="ss_img" id="user"></ion-icon></a>
                        <input type = "text" placeholder="What are you looking for?" id = "search"/>
                        <ion-icon name="search-sharp" id="search-icon"></ion-icon>
                    </div>
                    <div class="space"></div>
                    <div class="icon_reg">
                        <ion-icon name="search-sharp" id="mini_search" class="ss_img" onclick="return mini()"></ion-icon>
                        <a href="register.html" target = "_blank"><ion-icon name="person-sharp" class="ss_img"></ion-icon></a>
                        <ion-icon name="grid-sharp" id="dropdown_icon" class="ss_img" onclick="return dropdown()"></ion-icon>
                    </div>
                </header>
                <div class="small_screen" id="links">
                    <a class="nav_links" href="about_us.php" target="_parent">About Us</a> 
                    <a class="nav_links" href="products.php" target="_parent">Products</a> 
                    <a class="nav_links" href="services.php" target="_parent">Services</a> 
                    <a class="nav_links" href="projects.php" target="_parent">Projects</a>
                </div>
                <div class="small_screen" id="ss_search">
                    <input type = "text" placeholder="What are you looking for?" id = "search"/>
                </div>
            </form>
        </div>

        <!--About US Page Contents-->
        <div class="grid-container">
            <a href="index.php" class="grid-item-1"><ion-icon name="arrow-back-circle"></ion-icon> Homepage</a>
            <div class="space2"></div>
            <hr>
            <h1 class="grid-tem-2">Our Mission</h1>
            <p>The Lebanon energy crisis that started in late 2020 has left a lot of citizens without access to energy they need in their day to day.
                Hence, Solatrix was created on the mission to provide solar energy packages where people of all economic backgrounds can benefit from.
            </p>
            <hr>
            <h1 class="grid-item-3">Meet The Team!</h1>
            <p>Solatrix was founded in 2023 by two BAU students Abed Al Rahman Al Sharif and Mohammad Omar Shehab. 
                On the left is our mechanical engineer and computer scientist Mohammad Omar. 
                He has 3 years of experience in designing, installing, and maintaining solar energy systems.
                On the right is our senior computer scientist Abed Al Rahman. He is an expert Java programmer with a vast experience in programming Solar inverters and controllers.
            </p>
            <ion-icon name="person-sharp" id="moe_pic" class="member_img"></ion-icon>
            <ion-icon name="person-sharp" id="abed_pic" class="member_img"></ion-icon>
            <hr>
        </div>

        <!--Footer-->
        <?php
            require 'footer.php';
        ?>
    </body>
</html>