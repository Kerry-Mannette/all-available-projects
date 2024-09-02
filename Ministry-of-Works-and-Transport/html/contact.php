<?php
include_once('../php/client_contact_form_validation.php');
include_once('../php/client_subscribe_form_validation_subpage.php');
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
  <title>Ministry of Works and Transport - Contact Page</title>

  
  <!-- Favicon -->
  <link rel="icon" type="image/x-icon" href="../favicon/icon.png">

  <!-- Fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet"><!-- For more information on Google Fonts:  https://developers.google.com/fonts/docs/css2-->
 
  <!-- Custom styles for pages -->
  <link href="../css/style.css" rel="stylesheet">

  <!-- Responsive style -->
  <link href="../css/responsive.css" rel="stylesheet">

  <!-- All sourced images are from: https://pixabay.com/ -->
  <!-- All sourced icons are from:  https://www.flaticon.com/ -->


  
</head>

<body class="sub_page">

  <div class="main_area">
    <!-- header_section -->
    <header class="header_section">
        <nav class="navbar navbar-expand custom_nav-container ">
          <a class="navbar-brand" href="../index.php">
            <h1>
              Ministry of Works and Transport
            </h1>
          </a>
          
          <div class="collapse navbar-collapse">
            <ul class="navbar-nav  margin_left-auto">
              <li class="nav-item">
                <a class="nav-link" href="../index.php">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="about.php"> About</a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="contact.php">Contact <img src="../icons/tick.png" alt="Tick">
                </a>
              </li>
              
              <li class="nav-item">
                <a class="nav-link" href="../php/client_appointment_verification.php">
                    <img class="icon-appointment" src="../icons/appointment.png" alt="Appointment">
                    <span>
                        Appointment
                    </span>
                </a>
            </li>
              <li class="nav-item">
                <a class="nav-link" href="login.php">
                     <img class="icon-login" src="../icons/login.png" alt="Login">
                  <span>
                    Login
                  </span>
                </a>
              </li>
             
            </ul>
          </div>
        </nav>
        </header>
      </div>

    <!-- end header_section -->
 

  <!-- contact_section -->
  <section class="contact_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-2">
           
           <div class="contact_form">
           <div class="heading_container">
              <h2>
                Contact Us
              </h2>
              <h5>We typically get back to you in two to three working days</h5>
            </div>

           <form  id="contact_form"
            method="post" 
            action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"
            onsubmit="return validate();">
           <label for="name"><b>Name</b></label><br>
           <input type="text" name="name" id="name" maxlength="20" value="<?php echo $name;?>" required placeholder="e.g. John Doe"><br>
           <span id="name_err" class="validation_error"><?php echo $nameErr; ?></span><br>
           <label for="subject"><b>Subject</b></label><br>
           <input type="text" name="subject" id="subject" maxlength="30" value="<?php echo $subject;?>" required placeholder="e.g. Information Request"><br>
           <span id="subject_err" class="validation_error"><?php echo $subjectErr; ?></span><br>
           <label for="conemail"><b>Email</b></label><br>
           <input type="text" name="conemail" id="conemail" maxlength="40" value="<?php echo $conemail;?>" required placeholder="e.g. johndoe@gmail.com"><br>
           <span id="email_err" class="validation_error"><?php echo $conemailErr; ?></span><br>
           <label for="message"><b>Message</b></label><br>
           <textarea name="message" id="message" maxlength="400" value="<?php echo $message;?>" required placeholder="Your message"></textarea><br>
           <span id="message_err" class="validation_error"><?php echo $messageErr; ?></span><br>
           <input class="button_contact" type="submit" name="submit_contact" id="submit_contact" value="Submit" /> 
           </form>     
           </div>

        </div>
       
          <div class="address_box">
            <div class="heading_container">
                <h4>Contact Information</h4>
              </div>
              
                <img src="../icons/email.png" alt="Email">   
                <b>Email: <a href="mailto:ministryofworksandtransport.gov">ministryofworksandtransport.gov</a></b><br>
                
                <img src="../icons/phone_call.png" alt="Email">   
                <b>Phone Number: <a href="tel:1868-662-4256">1868-662-4256</a></b><br>

                <img src="../icons/pin.png" alt="Email">   
                <b>Location: <a href="https://maps.google.com/maps?q=129%20Henry%20ST%20Port%20of%20Spain&t=&z=13&ie=UTF8&iwloc=&output=embed">
                  #129 Henry ST Port of Spain</a></b><br>
                
            <div class="navigation_map">
                <iframe title="Contact_Map" 
                src="https://maps.google.com/maps?q=129%20Henry%20ST%20Port%20of%20Spain&t=&z=13&ie=UTF8&iwloc=&output=embed">
                </iframe>
            </div>
   
        </div>
      </div>
    </div>
  </section>
  <!-- end contact_section -->


  <!-- menu_footer_section -->
  <section class="info_section ">
    <div class="container">
      <div class="row">
        <div class="col-1 footer_nav_links">
          <h4>
            Menu
          </h4>
          <ul>
            <li>
              <a href="../index.php">
                Home
              </a>
            </li>
            <li>
              <a href="html/about.php">
                About
              </a>
            </li>
            <li class="active">
              <a class="" href="html/contact.php">
                Contact
              </a>
            </li>
            <li>
              <a class="" href="../php/client_appointment_verification.php">
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
 
    <img src="../icons/link.png" alt="Link">
    <a href="">Ministry of Education</a><br>

    <img src="../icons/link.png" alt="Link">
    <a href="">Ministry of Health</a><br>
 

    <img src="../icons/link.png" alt="Link">
    <a href="">Ministry of Energy</a><br>
 
    <img src="../icons/link.png" alt="Link">
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

<img src="../icons/telephone.png" alt="Telephone">
POS:<a href="tel:1868-662-4256">1868-662-4256</a><br>

<img src="../icons/telephone.png" alt="Telephone">
Arima:<a href="tel:1868-648-4535">1868-648-4535</a><br>

<img src="../icons/telephone.png" alt="Telephone">
Chag:<a href="tel:1868-668-5537">1868-668-5537</a><br>

</div>

</div>
<!-- end phone_number_section -->


 <!-- social_media_footer_section -->
        <div class="col-1">
    
            <h4>
              Social Links
            </h4>
           
                <a href="" aria-label="Facebook" >
                 <img class="facebook_icon" src="../icons/facebook.png" alt="Facebook">
                </a>
             
           
                <a href="" aria-label="Twitter" >
                  <img class="facebook_icon" src="../icons/instagram.png" alt="Facebook">
                </a>
              
             
                <a href="" aria-label="Linkedin">
                  <img class="facebook_icon" src="../icons/linkedin.png" alt="Facebook">
                </a>
             
        
                <a href="" aria-label="Instagram">
                  <img class="facebook_icon" src="../icons/youtube.png" alt="Facebook">
                </a>

        </div>
<!-- end social_footer_media_section -->


       <!-- subscribe_footer_section -->
          <div class=" subscribe_form col-1">
            <h4>
              Subscribe To Our Newsletter
            </h4>
         
                    <form
                     id="subscribe_form"
                     method="post" 
                     action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"
                     onsubmit="return validate();">
              <input type="text" name="subemail" id="subemail"  value="<?php echo $email;?>" required placeholder="Enter Your Email" />
              <span id="subemail_err" class="validation_error"><?php echo $emailErr; ?></span>
            <input class="button_subscribe" type="submit" name="submit_subscribe" id="submit_subscribe" value=" Subscribe" /> 
            </form>
          </div>
      </div>
    </div>
  </section>
   <!-- end subscribe_footer_section -->


  <!-- footer section -->
  <footer class="footer_section">
    <div class="container">
      <p>
       2023 &copy; All Rights Reserved By
        <a href="../index.php" >Ministry of Works and Transport</a>
      </p>
    </div>
  </footer>
  <!-- footer section -->

  <script src="../js/client_contact_form_validation.js"></script>
  <script src="../js/client_subscribe_form_validation.js"></script>

</body>

</html>