<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #000000;
            color: white;
            padding-top: 20px;
        }
        .center-content {
            height: 100vh;
        }
        .welcome-section {
            background-image: url('https://clipart-library.com/images/6Ty5EXL6c.jpg');
            background-size: contain;
            background-repeat: no-repeat;
            background-position: center;
            padding: 50px;
            border-radius: 15px;
        }
    </style>
</head>
<body>
<div class="d-flex">
    <nav class="sidebar d-flex flex-column align-items-center text-white p-3">
        <ul class="nav flex-column w-100 text-center">
            <li class="nav-item"><a class="nav-link text-white" href="/admin/services">Moderate Services</a></li>
            <li class="nav-item"><a class="nav-link text-white" href="/admin/reviews">Manage Reviews</a></li>
            <li class="nav-item"><a class="nav-link text-white" href="/admin/users">Manage Users</a></li>
            <li class="nav-item"><a class="nav-link text-white" href="/admin/stats">Statistics</a></li>
        </ul>
    </nav>

    <div class="container-fluid d-flex justify-content-center align-items-center center-content">
        <div class="text-center welcome-section">
            <h3 style="color:black;">Welcome to the PAW PAL Admin Dashboard</h3>
            <p style="color:black;">Manage services, users, and reports efficiently.</p>
        </div>
    </div>
</div>
</body>
</html>
