<!-- This is the official Ministry of Works and Transport website.

Website name: Ministry of Works and Transport
Developed by: Kerry Mannette
Date: 30/10/2022

Description: The Ministry of Works and Transport website was developed to create
an online registration system that administrators can access to register new users.
which allow clients to view their personal profiles, make appointments, and request
information.

-->

<?php
include_once('php/client_subscribe_form_validation.php');
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Site Metas -->
    <meta name="keywords" content="Ministry of Works and Transport">
    <meta name="description" content="This is the official Ministry of Works and Transport website">
    <meta name="author" content="Kerry Mannette">


    <!-- Page Title -->
    <title>Ministry of Works and Transport - Landing Page</title>

     <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="favicon/icon.png">

    <!-- Fonts Style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet"> <!-- For more information on Google Fonts:  https://developers.google.com/fonts/docs/css2-->

    <!-- Custom styles for pages -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Responsive style -->
    <link href="css/responsive.css" rel="stylesheet">

   <!-- All sourced images are from: https://pixabay.com/ -->
   <!-- All sourced icons are from:  https://www.flaticon.com/ -->

</head>

<body>

    <div class="main_area">
        <!-- header_section -->
        <header class="header_section">
                <nav class="navbar navbar-expand custom_nav-container ">
                    <a class="navbar-brand" href="index.php">
                        <H1>
                            Ministry of Works and Transport
                        </h1>
                    </a>

                    <ul class="navbar-nav  margin_left-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.php">Home <img src="icons/tick.png" alt="Tick">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="html/about.php"> About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="html/contact.php">Contact</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="php/client_appointment_verification.php">
                                <img class="icon-appointment" src="icons/appointment.png" alt="Appointment">
                                <span>
                                    Appointment
                                </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="html/login.php">
                                <img class="icon-login" src="icons/login.png" alt="Login">
                                <span>
                                    Login
                                </span>
                            </a>
                        </li>

                    </ul>
                </nav>
        </header>
        <!-- end header_section -->


        <!-- main_attraction -->
        <section class="main_attraction">
            <div class="container ">
                <div class="detail-box">
                    <h1>
                        Serving Our Citizens With Pride<br>
                    </h1>
                    <p>
                        Welcome to our official website<br> You are now able to book appointments for any of our
                        services<br> </p>
                    <div class="book_appointment_button" >

                            <button onclick="window.location.href='php/client_appointment_verification.php';">
                                
                                <b>Book Appointment</b>
                                <img src="icons/book_appointment.png" alt="Book Appointment Button">
                            </button>
                     
                    </div>

                   
                </div>
            </div>
        </section>    
    </div>
    
    <!-- end main_attraction -->


    <!-- about_section -->
    <div class="about_section ">
        <div class="container">
            <div class="row">
                <div class="col-2">

                    <div class="heading_container">
                      <article>   
                        <h2>
                            About Us
                        </h2>
                  
                   
                        <p>
                            The Ministry of Works and Transport is a government-funded organization. That is responsible
                            for the development and maintenance of the transportation infrastructure and engineering
                            works in the country.
                            
                        </p>
                    </article>

                    <a href="html/about.php">
                        Read More
                        <img class="icon-read_more" src="icons/read_more.png" alt="Read More">
                    </a>
                </div>
                </div>
                <div class="col-2">
                    <div class="img-box">
                        <img src="images/about_image.png" alt="About Image">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end about_section -->


    <!-- menu_footer_section -->
    <section class="info_section ">
        <div class="container">
            <div class="row">
                <div class="col-1 footer_nav_links">
                    <h4>
                        Menu
                    </h4>
                    <ul>
                        <li class="active">
                            <a href="../index.php">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="html/about.php">
                                About
                            </a>
                        </li>
                        <li>
                            <a class="" href="html/contact.php">
                                Contact
                            </a>
                        </li>
                        <li>
                            <a class="" href="php/client_appointment_verification.php">
                                Appointment
                            </a>
                        </li>
                        <li>
                            <a class="" href="html/login.php">
                                Login
                            </a>
                        </li>

                    </ul>
                </div>
                <!-- menu_footer_section -->


                <!-- usefull_links_section -->
                <div class="col-1">
                    <div class="usefull_links">
                        <h4>
                            Usefull Links
                        </h4>

                        <img src="icons/link.png" alt="Link">
                        <a href="">Ministry of Education</a><br>

                        <img src="icons/link.png" alt="Link">
                        <a href="">Ministry of Health</a><br>


                        <img src="icons/link.png" alt="Link">
                        <a href="">Ministry of Energy</a><br>

                        <img src="icons/link.png" alt="Link">
                        <a href="">Ministry of Finance</a><br>


                    </div>

                </div>
                <!-- end usefull_links_section -->


                <!-- phone_number_section -->
                <div class="col-1">
                    <div class="phone_numbers">
                        <h4>
                            Phone Numbers
                        </h4>

                        <img src="icons/telephone.png" alt="Telephone"> POS:
                        <a href="tel:1868-662-4256">1868-662-4256</a><br>

                        <img src="icons/telephone.png" alt="Telephone"> Arima:
                        <a href="tel:1868-648-4535">1868-648-4535</a><br>

                        <img src="icons/telephone.png" alt="Telephone"> Chag:
                        <a href="tel:1868-668-5537">1868-668-5537</a><br>
                    </div>

                </div>
                <!-- end phone_number_section -->


                <!-- social_media_footer_section -->
                <div class="col-1">
                    <div class="social_information">
                        <h4>
                            Social Links
                        </h4>

                        <a href="" aria-label="Facebook">
                            <img class="facebook_icon" src="icons/facebook.png" alt="Facebook">
                        </a>


                        <a href="" aria-label="Twitter">
                            <img class="facebook_icon" src="icons/instagram.png" alt="Facebook">
                        </a>


                        <a href="" aria-label="Linkedin">
                            <img class="facebook_icon" src="icons/linkedin.png" alt="Facebook">
                        </a>

                        
                        <a href="" aria-label="Instagram">
                            <img class="facebook_icon" src="icons/youtube.png" alt="Facebook">
                        </a>
                    </div>
                </div>
                <!-- end social_footer_media_section -->
             
                <!-- subscribe_footer_section -->
                <div class=" subscribe_form col-1">
                    <h4>
                        Subscribe To Our Newsletter
                    </h4>
                    <?php
                   include_once('php/client_subscribe_form_validation.php');
                   ?>
                    <form 
                     id="subscribe_form"
                     method="post" 
                     action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"
                     onsubmit="return validate();" >
                        <input type="text" name="subemail" id="subemail" value="<?php echo $email;?>" required placeholder="Enter Your Email" />
                        <span id="email_err" class="validation_error"><?php echo $emailErr; ?></span>
                        <input class="button_subscribe" type="submit" name="submit_subscribe" id="submit_subscribe" value=" Subscribe" /> 
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!-- end subscribe_footer_section -->


    <!-- footer_section -->
    <footer class="footer_section">
        <div class="container">
            <p>
                2023 &copy; All Rights Reserved By
                <a href="index.php">Ministry of Works and Transport</a>
            </p>
        </div>
    </footer>
    <!-- footer_section -->
    
<script src="js/client_subscribe_form_validation.js"></script>

</body>

</html>