// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('picmain1'));
var myTable = document.getElementById('tableFirst');
// 指定图表的配置项和数据
//              myChart.setOption({
//                  title: {
//				       text: '近七日收益'
//				    },
//				    tooltip: {
//				        trigger: 'axis'
//				    },
//				    legend: {
//				        data:['近七日收益']
//				    },
//				    grid: {
//				        left: '3%',
//				        right: '4%',
//				        bottom: '3%',
//				        containLabel: true
//				    },
//				    toolbox: {
//				        feature: {
//				            saveAsImage: {}
//				        }
//				    },
//				    xAxis: {
//				        type: 'category',
//				        boundaryGap: false,
//				        data: ["1","2","3","4","5"]
//				    },
//				    yAxis: {
//				        type: 'value'
//				    },
//				    series: [
//
//				        {
//				            name:'近七日收益',
//				            type:'line',
//				            stack: '总量',
//				            data:["1","2","3","4","5"]
//				        }
//				    ]
//			});
myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
// 异步加载数据
$.get('data1.json').done(function(data) {
    myChart.setOption({
        backgroundColor:"#FFF",
        title: {
            text: '月收益'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {                             //图标
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: data.categories
        },
        yAxis: {},
        series: [{                        //图标类型（柱状图，饼状图..）
            //name=legend.data的时候才能显示图例
            name: '收益',
            type: 'line',
            stack: '总量',
            data: data.data
        }]

    });
});
myChart.hideLoading();

refreshData();