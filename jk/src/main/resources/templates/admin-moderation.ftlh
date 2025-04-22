<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Moderate Services</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .btn-approve {
            background-color: #28a745;
            color: white;
        }
        .btn-remove {
            background-color: #dc3545;
            color: white;
        }
        .bg-black {
            background-color: #343a40;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Moderate Services</h1>

    <!-- Service Moderation Section -->
    <ul class="list-group mb-5">
        <#if services?? && services?size > 0>
        <#list services as service>
        <li class="list-group-item d-flex justify-content-between align-items-center">
            <div>
                <strong>${service.name}</strong> - ${service.description}
                <#if service.approved?? && service.approved>
                <span class="badge badge-success ml-2">Approved</span>
                <#else>
                <span class="badge badge-warning ml-2">Pending</span>
            </#if>
</div>
<div>
    <form method="post" action="/admin/services/approve/${service.id}" style="display:inline;">
        <button class="btn btn-approve btn-sm" type="submit">Approve</button>
    </form>
    <form method="post" action="/admin/services/delete/${service.id}" style="display:inline;">
        <button class="btn btn-remove btn-sm" type="submit">Remove</button>
    </form>
</div>
</li>
</#list>
<#else>
<li class="list-group-item">No services available.</li>
</#if>
</ul>

<!-- Flagged Services Section -->
<div class="card mb-4">
    <div class="card-header text-white bg-black">
        <h3>Flagged Services</h3>
    </div>
    <div class="card-body">
        <ul class="list-group">
            <#if flaggedServices?? && flaggedServices?size > 0>
            <#list flaggedServices as service>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                ${service.name} - Reported by ${service.reportCount} users
                <div>
                    <form method="post" action="/admin/services/delete/${service.id}" style="display:inline;">
                        <button class="btn btn-remove btn-sm" type="submit">Remove</button>
                    </form>
                    <form method="post" action="/admin/services/approve/${service.id}" style="display:inline;">
                        <button class="btn btn-approve btn-sm" type="submit">Reinstate</button>
                    </form>
                </div>
            </li>
        </#list>
        <#else>
        <li class="list-group-item">No flagged services found.</li>
    </#if>
    </ul>
</div>
</div>
</div>
</body>
</html>