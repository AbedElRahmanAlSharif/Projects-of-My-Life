<!DOCTYPE html>
<html>
    <head>
        <title>Your Cart</title>
        <link rel="stylesheet" href = "../css files/stylesheet_1.css"/>
        <link rel="stylesheet" href = "../css files/cart.css"/>
        <script type = "text/javascript" src = "../javascript files/script_1.js" defer></script>
    </head>
    <body>
        <!--Navigation Bar-->
        <?php session_start();
        require 'config.php';
        require 'header.php'; ?>

        <!--Products Page Contents-->
        <div class="cart">
            <div class="grid-item-1">
                <a href="index.php"><ion-icon name="arrow-back-circle"></ion-icon> Homepage </a>
                <a href="products.php"><ion-icon name="arrow-back-circle"></ion-icon> Products</a>
            </div>
            <hr>
            <table>
                <tr>
                    <th colspan="2">Item</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Total Price</th>
                    <th>Operation</th>
                </tr>
            <?php
                require 'config.php';
                if(isset($_GET['delete'])){
                    $delete_table = $_GET['table'];
                    $delete_id = $_GET['pid'];
                    $delete_user = $_GET['user'];
                    $delete_sql = "DELETE FROM cart WHERE username = '".$delete_user."' AND pd_table = '".$delete_table."' AND pid = '".$delete_id."'";
                    $conn->query($delete_sql);
                }
                if(isset($_GET['user'])){
                    $username = $_GET['user'];
                    $sql = "SELECT * FROM cart where username = '".$username."'";
                    $items = $conn->query($sql);
                    if ($items->num_rows > 0){
                        while($row=$items->fetch_assoc()){
                           $table = $row['pd_table'];
                           $pid = (int)$row['pid'];
                           $item_sql = "SELECT Manufacturer, Model, Price, ImgDirec FROM ".$table." WHERE ID = ".$pid;
                           $details = $conn->query($item_sql);
                           $detials_array = $details->fetch_assoc();
                           $username = 'k';
                           echo '<tr>
                                    <td class="image"><img src="'.$detials_array["ImgDirec"].'/img1.jpg" alt="product image"/>
                                    <td>'.$detials_array['Manufacturer'].' '.$detials_array['Model'].'</td>
                                    <td>TBD</td>
                                    <td>'.$detials_array['Price'].'</td>
                                    <td>TBD</td>
                                    <td>
                                        <a href="cart.php?user='.$username.'&table='.$table.'&pid='.$pid.'&delete=1" class="delete"><ion-icon name="trash-sharp"></ion-icon> Delete</a>
                                    </td>
                                </tr>';
                        }
                    }
                }
                else{
                    header('location: register.php');
                }
            ?>
            </table>
        </div>

        <!--Footer-->
        <?php
            require 'footer.php';
        ?>
    </body>
</html>