<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>问卷系统</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="/survey/static/AdminLTE/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="/survey/static/AdminLTE/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
            page. However, you can choose any other skin. Make sure you
            apply the skin class to the body tag so the changes take effect.
        -->
        <link rel="stylesheet" href="/survey/static/AdminLTE/dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet" href="/survey/static/css/system.css">
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
        <!-- jQuery 2.2.0 -->
        <script src="/survey/static/AdminLTE/plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="/survey/static/AdminLTE/bootstrap/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="/survey/static/AdminLTE/dist/js/app.min.js"></script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="#" class="logo">
                  <!-- mini logo for sidebar mini 50x50 pixels -->
                  <span class="logo-mini"><b>A</b>LT</span>
                  <!-- logo for regular state and mobile devices -->
                  <span class="logo-lg"><b>Admin</b>LTE</span>
                </a>
            
                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            
                            <!-- User Account Menu -->
                            <li class="dropdown user user-menu">
                                <!-- Menu Toggle Button -->
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                  <!-- The user image in the navbar-->  <!-- 用户图片 -->
                                  <img src="/survey/static/AdminLTE/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                  <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                  <span class="hidden-xs">Alexander Pierce</span>
                                </a>
                                <ul class="dropdown-menu">
                                  <!-- The user image in the menu -->
                                  <li class="user-header">
                                    <img src="/survey/static/AdminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                    
                                    <p>
                                      Alexander Pierce - Web Developer
                                      <small>Member since Nov. 2012</small>
                                    </p>
                                  </li>
                                  <!-- Menu Body -->
                                  <li class="user-body">
                                    <div class="row">
                                      <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                      </div>
                                      <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                      </div>
                                      <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                      </div>
                                    </div>
                                    <!-- /.row -->
                                  </li>
                                  <!-- Menu Footer-->
                                  <li class="user-footer">
                                    <div class="pull-left">
                                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                      <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                  </li>
                                </ul>
                            </li>
              
                        </ul>
                    </div>
                </nav>
            </header>
            
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
            
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
            
                  <!-- Sidebar user panel (optional) -->
                  <div class="user-panel">
                    <div class="pull-left image">
                      <img src="/survey/static/AdminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                    </div>
                    <div class="pull-left info">
                      <p>Alexander Pierce</p>
                      <!-- Status -->
                      <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                  </div>
            
                  <!-- search form (Optional) -->
                  <form action="#" method="get" class="sidebar-form">
                    <div class="input-group">
                      <input type="text" name="q" class="form-control" placeholder="Search...">
                          <span class="input-group-btn">
                            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                            </button>
                          </span>
                    </div>
                  </form>
                  <!-- /.search form -->
            
                  <!-- Sidebar Menu -->
                  <ul class="sidebar-menu">
                    <li class="header">HEADER</li>
                    <!-- Optionally, you can add icons to the links -->
                    <#if menuInfoList??>
                        <#list menuInfoList as menuLevel1>
                            <#if menuLevel1.haveSon=='Y'>
                                <li class="treeview">
                                    <a href="#"><i class="${menuLevel1.moduleIcon!''}"></i> <span>${menuLevel1.menuName!''}</span> <i class="fa fa-angle-left pull-right"></i></a>
                                    <ul class="treeview-menu">
                                        <#if menuLevel1.munuInfoVOs??>
                                            <#list menuLevel1.munuInfoVOs as menuLevel2>
                                                <li><a href="#"><i class="${menuLevel1.moduleIcon!''}"></i><span>${menuLevel2.menuName!''}</span></a></li>
                                            </#list>
                                        </#if>
                                    </ul>
                                </li>
                            <#else>
                                <li><a href="#"><i class="${menuLevel1.moduleIcon!''}"></i> <span>${menuLevel1.menuName!''}</span></a></li>
                            </#if>
                        </#list>
                    </#if>
                    
                  </ul>
                  <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>
            
            <!-- Content Wrapper. Contains page content ++++++++++++++++++++++++++++++++++++++-->
            <div class="content-wrapper" >
                <div class="embed-responsive embed-responsive-1by1">
                <iframe name="navTabl">
                    qqq
                </iframe>
                </div>
            </div>
            <!-- /.content-wrapper -->
            
            <!-- Main Footer -->
            <footer class="main-footer">
                <!-- To the right -->
                <div class="pull-right hidden-xs">
                  Anything you want
                </div>
                <!-- Default to the left -->
                <strong>Copyright &copy; 2016 <a href="#">juqi</a>.</strong> All rights reserved.
            </footer>
            
            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Create the tabs -->
                <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                  <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                  <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                  <!-- Home tab content -->
                  <div class="tab-pane active" id="control-sidebar-home-tab">
                    <h3 class="control-sidebar-heading">Recent Activity</h3>
                    <ul class="control-sidebar-menu">
                      <li>
                        <a href="javascript::;">
                          <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                
                          <div class="menu-info">
                            <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                
                            <p>Will be 23 on April 24th</p>
                          </div>
                        </a>
                      </li>
                    </ul>
                    <!-- /.control-sidebar-menu -->
                
                    <h3 class="control-sidebar-heading">Tasks Progress</h3>
                    <ul class="control-sidebar-menu">
                      <li>
                        <a href="javascript::;">
                          <h4 class="control-sidebar-subheading">
                            Custom Template Design
                            <span class="label label-danger pull-right">70%</span>
                          </h4>
                
                          <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                          </div>
                        </a>
                      </li>
                    </ul>
                    <!-- /.control-sidebar-menu -->
                
                  </div>
                  <!-- /.tab-pane -->
                  <!-- Stats tab content -->
                  <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
                  <!-- /.tab-pane -->
                  <!-- Settings tab content -->
                  <div class="tab-pane" id="control-sidebar-settings-tab">
                    <form method="post">
                      <h3 class="control-sidebar-heading">General Settings</h3>
                
                      <div class="form-group">
                        <label class="control-sidebar-subheading">
                          Report panel usage
                          <input type="checkbox" class="pull-right" checked>
                        </label>
                
                        <p>
                          Some information about this general settings option
                        </p>
                      </div>
                      <!-- /.form-group -->
                    </form>
                  </div>
                  <!-- /.tab-pane -->
                </div>
            </aside>
            <!-- /.control-sidebar -->
  
            <!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>        
    </body>
</html>