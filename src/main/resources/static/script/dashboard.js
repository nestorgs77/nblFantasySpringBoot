/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace()

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        'J1',
        'J2',
        'J3',
        'J4',
        'J5',
        'J6',
        'J7',
        'J8',
        'J9',
        'J10',
        'J11',
        'J12',
        'J13',
        'J14',
        'J15',
        'J16',
        'J17',
        'J18',
        'J19',
        'J20',
        'J21',
        'J22',
        'J23',
        'J24',
        'J25',
        'J26',
        'J27',
        'J28',
        'J29',
        'J30',
        'J31',
        'J32',
        'J33',
        'J34',
        'J35',
        'J36',
        'J37',
        'J38'
      ],
      datasets: [{
       data:[20,56],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
}())
