$(document).ready(function () {
  // Form buttom bind
  $("#button-search").bind('click', function (e) {
    // Clear previous error and results if any
    $("#content-error").remove();
    $('#table-country-body').empty();
    $('#content-table').hide();   // hide table

    // Fetch content from REST API
    searchCountry();
  });
});

function searchCountry() {
  // GET form params
  var countryCode = $("#input-countryCode").val();
  var region = $("#input-region").val();
  var incomeType = $("#input-incomeLevel").val();
  var lendingType = $("#input-lendingType").val();

  // Make HTTP request
  $.ajax({

    'url': 'http://192.168.1.186:8080/v1/country',
    'type': 'GET',
    'data': {
      'countryCode': countryCode,
      'region': region,
      'incomeLabel': incomeType,
      'lendingType': lendingType
    },
    'success': function (data) {
      if (data.length > 0) {
        refreshContent(data);
      } else {
        resultError('No result found');
      }
    },
    'error': function (jqXHR, textStatus, error) {
      if (jqXHR.status === 400) {
        resultError('Status: ' + jqXHR.status + ' - ' + jqXHR.responseJSON.message);
      } else {
        resultError('Error calling Country API ' + jqXHR.status);
      }
    },
    timeout: 3000 // timeout to 3 sec
  });
}

function resultError(message) {
  $("#content-main").append('<div id="content-error"><strong>' + message + '</strong></div>');
}

function refreshContent(data) {
  $('#content-table').show();   // display table
  data.forEach(function (item, index) {
    $("#table-country-body").append('<tr><td>' + item.countryName + '</td><td>' + item.capital + '</td></tr>');

  });
}
