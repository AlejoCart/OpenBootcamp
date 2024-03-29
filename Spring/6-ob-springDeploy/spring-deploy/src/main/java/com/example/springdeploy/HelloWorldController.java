package com.example.springdeploy;//package com.example.obrestDataJpa.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@AllArgsConstructor
@RestController
public class HelloWorldController {

    @Value("${app.message}")
    String message;

    private static final String PATH="/Hola";
    @GetMapping(PATH)
    //@RequestMapping(value="/hola")
    public String holas(){
        System.out.println(message);
        return "Hola mundo, que tal tu dia? Todo bien por casa?";
    }

    @GetMapping("/boostrap")
    public String boostrap(){
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <meta name="description" content="">
                    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
                    <meta name="generator" content="Hugo 0.108.0">
                    <title>Signin Template · Bootstrap v5.3</title>
                                
                    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
                                
                   \s
                                
                   \s
                                
                <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
                                
                    <style>
                      .bd-placeholder-img {
                        font-size: 1.125rem;
                        text-anchor: middle;
                        -webkit-user-select: none;
                        -moz-user-select: none;
                        user-select: none;
                      }
                                
                      @media (min-width: 768px) {
                        .bd-placeholder-img-lg {
                          font-size: 3.5rem;
                        }
                      }
                                
                      .b-example-divider {
                        height: 3rem;
                        background-color: rgba(0, 0, 0, .1);
                        border: solid rgba(0, 0, 0, .15);
                        border-width: 1px 0;
                        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
                      }
                                
                      .b-example-vr {
                        flex-shrink: 0;
                        width: 1.5rem;
                        height: 100vh;
                      }
                                
                      .bi {
                        vertical-align: -.125em;
                        fill: currentColor;
                      }
                                
                      .nav-scroller {
                        position: relative;
                        z-index: 2;
                        height: 2.75rem;
                        overflow-y: hidden;
                      }
                                
                      .nav-scroller .nav {
                        display: flex;
                        flex-wrap: nowrap;
                        padding-bottom: 1rem;
                        margin-top: -1px;
                        overflow-x: auto;
                        text-align: center;
                        white-space: nowrap;
                        -webkit-overflow-scrolling: touch;
                      }
                    </style>
                                
                   \s
                    <!-- Custom styles for this template -->
                    <link href="sign-in.css" rel="stylesheet">
                  </head>
                  <body class="text-center">
                   \s
                <main class="form-signin w-100 m-auto">
                  <form>
                    <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                                
                    <div class="form-floating">
                      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                      <label for="floatingInput">Email address</label>
                    </div>
                    <div class="form-floating">
                      <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                      <label for="floatingPassword">Password</label>
                    </div>
                                
                    <div class="checkbox mb-3">
                      <label>
                        <input type="checkbox" value="remember-me"> Remember me
                      </label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                    <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
                  </form>
                </main>
                                
                                
                   \s
                  </body>
                </html>
                                
                """;
    }

}
