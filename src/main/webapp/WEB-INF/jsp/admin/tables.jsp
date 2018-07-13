<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
  <title>ç¨æ·ç®¡ç</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width">        
  <link rel="stylesheet" href="css/templatemo_main.css">
<!-- 
Dashboard Template 
http://www.templatemo.com/preview/templatemo_415_dashboard
-->
</head>
<body>
  <div id="main-wrapper">
    <div class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <div class="logo"><h1>å¾®ååå°ç®¡ç</h1></div>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button> 
      </div>   
    </div>
    <div class="template-page-wrapper">
      <div class="navbar-collapse collapse templatemo-sidebar">
        <ul class="templatemo-sidebar-menu">
          <li><a href="index.html"><i class="fa fa-home"></i>æ¦è§</a></li>
          <li class="sub">
            <a href="javascript:;">
              <i class="fa fa-database"></i>å¾®åç®¡ç<div class="pull-right"><span class="caret"></span></div>
            </a>
            <ul class="templatemo-submenu">
              <li><a href="#">Aenean</a></li>
              <li><a href="#">Pelrdum</a></li>
            </ul>
          </li>
          <li class="active"><a href="tables.html"><i class="fa fa-users"></i>ç¨æ·ç®¡ç</a></li>
          <li><a href="preferences.html"><i class="fa fa-cog"></i>å¯ç ä¿®æ¹</a></li>
          <li><a href="javascript:;" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>éåºç»å½</a></li>
        </ul>
      </div><!--/.navbar-collapse -->

      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          
          <h1>ç¨æ·ç®¡ç</h1>

          <div class="row margin-bottom-30">
            <div class="col-md-12">
              <ul class="nav nav-pills">
                <li class="active"><a href="#">New Users <span class="badge">42</span></a></li>
                <li><a href="#">Active Users <span class="badge">107</span></a></li>
                <li><a href="#">Expired Users <span class="badge">3</span></a></li>
              </ul>          
            </div>
          </div> 
          <div class="row">
            <div class="col-md-12">
              <div class="btn-group pull-right" id="templatemo_sort_btn">
                <button type="button" class="btn btn-default">Sort by</button>
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                  <span class="caret"></span>
                  <span class="sr-only">Toggle Dropdown</span>
                </button>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">First Name</a></li>
                  <li><a href="#">Last Name</a></li>
                  <li><a href="#">Username</a></li>
                </ul>
              </div>
              <div class="table-responsive">
                <h4 class="margin-bottom-15">New Users Table</h4>
                <table class="table table-striped table-hover table-bordered">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Username</th>
                      <th>Email</th>
                      <th>Edit</th>
                      <th>Action</th>
                      <th>Delete</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>John</td>
                      <td>Smith</td>
                      <td>@js</td>
                      <td>a@company.com</td>
                      <td><a href="#" class="btn btn-default">Edit</a></td>                    
                      <td>
                        <!-- Split button -->
                        <div class="btn-group">
                          <button type="button" class="btn btn-info">Action</button>
                          <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                          </button>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Bootstrap</a></li>
                            <li><a href="#">Font Awesome</a></li>
                            <li><a href="#">jQuery</a></li>
                          </ul>
                        </div>
                      </td>
                      <td><a href="#" class="btn btn-link">Delete</a></td>
                    </tr>
                                       
                  </tbody>
                </table>
              </div>
              </div>
              <ul class="pagination pull-right">
                <li class="disabled"><a href="#">&laquo;</a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">3 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">4 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">5 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">&raquo;</a></li>
              </ul>  
            </div>
          </div>
        </div>
      </div>

      <!-- Modal -->
      <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">Are you sure you want to sign out?</h4>
            </div>
            <div class="modal-footer">
              <a href="sign-in.html" class="btn btn-primary">Yes</a>
              <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
            </div>
          </div>
        </div>
      </div>

    </div>
</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/templatemo_script.js"></script>
  </body>
</html>