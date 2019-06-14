$(document).ready(function () {
    console.log('customer.js loaded');
    createDataTable();
});

function createDataTable() {
    console.log('create data table');
    $('#customer-table').DataTable({
        "serverSide": true,
        "ajax": "admin?action=searchCustomers"
    });
}