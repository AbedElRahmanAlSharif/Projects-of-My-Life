<?php
    session_start();

    include_once 'config.php';
    $msg = "";


    if (isset($_POST['submit'])) {
        $email = mysqli_real_escape_string($conn, $_POST['email']);
        $password = mysqli_real_escape_string($conn, md5($_POST['password']));

        $sql = "SELECT * FROM users WHERE email='$email' AND password='$password'";
        $result = mysqli_query($conn, $sql);
        $row = $result->fetch_assoc();
        if (mysqli_num_rows($result) > 0) {
            print_r($row);
                $_SESSION['user_name'] = $row['name'];
                $_SESSION['LOGIN'] = true;
                header('location: index.php');
                exit(); // Use exit() after header() to stop further execution
        } else {
            $msg = "<div class='alert alert-danger'>Email or password do not match.</div>";
        }
    }
?>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Login Form</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords"
        content="Login Form" />
    <!-- //Meta tag Keywords -->

    <link href="//fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <!--/Style-CSS -->
    <link rel="stylesheet" href="style.css" type="text/css" media="all" />
    <!--//Style-CSS -->

    <script src="https://kit.fontawesome.com/af562a2a63.js" crossorigin="anonymous"></script>

</head>

<body>

    <!-- form section start -->
    <section class="w3l-mockup-form">
        <div class="container">
            <!-- /form -->
            <div class="workinghny-form-grid">
                <div class="main-mockup">
                    <div class="w3l_form align-self">
                        <div class="left_grid_info">
                            <img src="images-20230424T110100Z-001\images\Authentication_Two Color (1).png" alt="">
                        </div>
                    </div>
                    <div class="content-wthree">
                        <h2>Login Now</h2>
                        <p>Hello their, and welcome.</p>
                        <?php echo $msg; ?>
                        <form action="" method="post">
                            <input type="email"  class="email" name="email" placeholder="Enter Your Email" required>
                            <div style="position: relative;">
                            <input type="password" id="pass" class="password" name="password" placeholder="Enter Your Password" style="margin-bottom: 2px;" required>
                            <button onclick="ShowandHide()" style="position:absolute; right:0px; width:52px; height:100%;" type="button">
                       
                            <ion-icon id="icon-eye" name="eye-sharp"></ion-icon>
                           
                            </button>
                            </div>
                            <p><a href="forget-password.php" style="margin-bottom: 15px; display: block; text-align: right;">Forgot Password?</a></p>
                            <button name="submit" name="submit" class="btn" type="submit">Login</button>
                        </form>
                        <div class="social-icons">
                            <p>Create Account! <a href="register.php">Register</a>.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- //form -->
        </div>
    </section>
    <!-- //form section start -->

    <script src="js/jquery.min.js"></script>
    <script>
        $(document).ready(function (c) {
            $('.alert-close').on('click', function (c) {
                $('.main-mockup').fadeOut('slow', function (c) {
                    $('.main-mockup').remove();
                });
            });
        });
    </script>
    <script defer>
        function ShowandHide(){
            var pass = document.getElementById("pass");
            var eye = document.getElementById("icon-eye");
            if(pass.type === "password"){
                pass.type = "text";
                eye.name="eye-sharp";
        }
        else{
            pass.type = "password";
            eye.name="eye-off-sharp";
        }
    }
    </script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>

</html>
