<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
<div class="header-area header-transparent">
    <div class="main-header">
        <div class="header-bottom header-sticky">
            <div class="container-fluid">
                <div class="row align-items-center">

                    <div class="col-xl-2 col-lg-2">
                        <div class="logo">
                            <a href="${pageContext.request.contextPath}/home">
                                <img src="${pageContext.request.contextPath}/clienttemplate/${pageContext.request.contextPath}/clienttemplate/assets/img/logo/logo.png">
                            </a>
                        </div>
                    </div>

                    <div class="col-xl-10 col-lg-10">
                        <div class="menu-wrapper d-flex align-items-center justify-content-end">
                            <div class="main-menu d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                                        <li><a href="#">Courses</a></li>
                                        <li><a href="#">About</a></li>
                                        <li><a href="#">Contact</a></li>
                                        <li class="button-header">
                                            <a href="#" class="btn">Join</a>
                                        </li>
                                        <li class="button-header">
                                            <a href="#" class="btn btn3">Login</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</header>
