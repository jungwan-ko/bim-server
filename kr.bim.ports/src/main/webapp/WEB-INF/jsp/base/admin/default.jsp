<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@include file="./inc/inc_header.jsp"%>
</head>
<body class="xp-vertical">
	<div id="xp-container" v-cloak>
		<div class="xp-leftbar">
			<div class="xp-sidebar">
				<div class="xp-logobar text-center">
					<a href="index.html" class="xp-logo">
						<img src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/images/noaa-logo.png" class="img-fluid" alt="logo" style="width: 180px">
					</a>
				</div>
				<%@include file="./inc/inc_navi.jsp"%>
			</div>
		</div>
		<div class="xp-rightbar">
			<div class="xp-topbar">
				<div class="row">
					<div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
						<div class="xp-menubar">
							<a class="xp-menu-hamburger" href="javascript:void();">
								<i class="mdi mdi-sort-variant font-24 text-white"></i>
							</a>
						</div>
					</div>
                    <div class="col-md-5 col-lg-3 order-3 order-md-2"></div>
                    <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                    	<%@include file="./inc/inc_top.jsp"%>
                    </div>
				</div>
			</div>             
			<router-view></router-view>
            <%@include file="./inc/inc_bottom.jsp"%>
        </div>
    </div>    
    <%@include file="./inc/inc_header2.jsp"%>
    
    <!-- summernote JS -->
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/summernote/summernote-bs4.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/summernote/lang/summernote-ko-KR.js"></script>
    <!-- Dropzone JS -->
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/dropzone/dist/dropzone.js"></script>
    <script type="text/javascript">
	    $(document).ready(function() {
	    	$(document).on("click","#btnFileAdd",function(){
	    		$("#fileLayer").append('<div class="row"><div class="form-group col-sm-10"><input type="file" id="uploadFiles" name="uploadFiles" class="form-control"></div><div class="form-group col-sm-2"><button type="button" class="btn btn-outline-danger" id="btnFileDel"><i class="mdi mdi-delete-sweep"></i></button></div></div>');
	    	});	    	
	    	$(document).on("click","#btnFileDel",function(){
	    		$(this).parent().parent().remove();
	    	}); 
	    	
	   	});
	   	
	    var durTime=1000*60;
	    function fnCreateMenuLog(){
	    	if($("#prgID").val()!=""){
	    		$.ajax({
	    			type: "POST",
	    			url: "/api/admin/menu/history/create",
	    			dataType: 'json',
	    			contentType: 'application/json; charset=utf-8',
	    			data:JSON.stringify({ pg: $("#prgID").val(),paramDurMils:durTime })
	    		})
	    		.done(function( msg ) {
	    			console.log(msg);
	    		});
	    	}
	    }
		fnCreateMenuLog();
		window.setInterval("fnCreateMenuLog()",durTime);
	    
	    Dropzone.autoDiscover = false;
	    Dropzone.prototype.defaultOptions.dictDefaultMessage = "마우스로 파일을 끌어오세요.";
	    Dropzone.options.mydropzone = {
	    	addRemoveLinks: true,
	    	autoProcessQueue: true,	    	
	    	uploadMultiple: false,
	    	parallelUploads: 1,
	    	maxFiles: 20,
	    	paramName: 'uploadFiles',
	    	previewsContainer: '#dropzonePreview',
	    	clickable: true,
	    	accept: function(file, done) {
	    		done();
	    	},
	    	error: function(file, msg){
	    		alert(msg);
	    	},
	    	removedfile: function(file) {
	    		var responsetext = JSON.parse(file.xhr.responseText);
	    		$.ajax({
	    			type: 'GET',
	    			url: '/file/drop/'+responsetext.file_grp_key_max,
	    			dataType: 'html'
	    		});
	    		var _ref;
	    		return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;
	    	},
	    	init: function() {
	    		var myDropzone = this;
	    		document.getElementById("sbmtbtn").onclick = function(e) {
	    			e.preventDefault();
	    			myDropzone.processQueue();	    			
	    		};
	    		this.on("success", function(file, responseText) {
	    			$('#fileGroup').val(responseText.file_grp_id);	    			
	    		});
	    	}
	    };
	</script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/contents/noaa/js/model/vue/admin-controller.min.js"></script>
    
    
    
    
    <!-- D3 JS -->
    <!-- <script src="https://d3js.org/d3.v3.min.js"></script>
    <script>
		window.addEventListener('message', function(e) {
		    var opts = e.data.opts,
		        data = e.data.data;
		
		    return main(opts, data);
		});
		
		var defaults = {
		    margin: {top: 24, right: 0, bottom: 0, left: 0},
		    rootname: "TOP",
		    format: ",d",
		    title: "",
		    width: 1500,
		    height: 700
		};
		
		function main(o, data) {
		  var root,
		      opts = $.extend(true, {}, defaults, o),
		      formatNumber = d3.format(opts.format),
		      rname = opts.rootname,
		      margin = opts.margin,
		      theight = 36 + 16;
		
		  $('#chartTree').width(opts.width).height(opts.height);
		  var width = opts.width - margin.left - margin.right,
		      height = opts.height - margin.top - margin.bottom - theight,
		      transitioning;
		  
		  var color = d3.scale.category20c();
		  
		  var x = d3.scale.linear()
		      .domain([0, width])
		      .range([0, width]);
		  
		  var y = d3.scale.linear()
		      .domain([0, height])
		      .range([0, height]);
		  
		  var treemap = d3.layout.treemap()
		      .children(function(d, depth) { return depth ? null : d._children; })
		      .sort(function(a, b) { return a.value - b.value; })
		      .ratio(height / width * 0.5 * (1 + Math.sqrt(5)))
		      .round(false);
		  
		  var svg = d3.select("#chartTree").append("svg")
		      .attr("width", width + margin.left + margin.right)
		      .attr("height", height + margin.bottom + margin.top)
		      .style("margin-left", -margin.left + "px")
		      .style("margin.right", -margin.right + "px")
		    .append("g")
		      .attr("transform", "translate(" + margin.left + "," + margin.top + ")")
		      .style("shape-rendering", "crispEdges");
		  
		  var grandparent = svg.append("g")
		      .attr("class", "grandparent");
		  
		  grandparent.append("rect")
		      .attr("y", -margin.top)
		      .attr("width", width)
		      .attr("height", margin.top);
		  
		  grandparent.append("text")
		      .attr("x", 6)
		      .attr("y", 6 - margin.top)
		      .attr("dy", ".75em");
		
		  if (opts.title) {
		    $("#chartTree").prepend("<p class='title'>" + opts.title + "</p>");
		  }
		  if (data instanceof Array) {
		    root = { key: rname, values: data };
		  } else {
		    root = data;
		  }
		    
		  initialize(root);
		  accumulate(root);
		  layout(root);
		  console.log(root);
		  display(root);
		
		  if (window.parent !== window) {
		    var myheight = document.documentElement.scrollHeight || document.body.scrollHeight;
		    window.parent.postMessage({height: myheight}, '*');
		  }
		
		  function initialize(root) {
		    root.x = root.y = 0;
		    root.dx = width;
		    root.dy = height;
		    root.depth = 0;
		  }
		
		  // Aggregate the values for internal nodes. This is normally done by the
		  // treemap layout, but not here because of our custom implementation.
		  // We also take a snapshot of the original children (_children) to avoid
		  // the children being overwritten when when layout is computed.
		  function accumulate(d) {
		    return (d._children = d.values)
		        ? d.value = d.values.reduce(function(p, v) { return p + accumulate(v); }, 0)
		        : d.value;
		  }
		
		  // Compute the treemap layout recursively such that each group of siblings
		  // uses the same size (1×1) rather than the dimensions of the parent cell.
		  // This optimizes the layout for the current zoom state. Note that a wrapper
		  // object is created for the parent node for each group of siblings so that
		  // the parent’s dimensions are not discarded as we recurse. Since each group
		  // of sibling was laid out in 1×1, we must rescale to fit using absolute
		  // coordinates. This lets us use a viewport to zoom.
		  function layout(d) {
		    if (d._children) {
		      treemap.nodes({_children: d._children});
		      d._children.forEach(function(c) {
		        c.x = d.x + c.x * d.dx;
		        c.y = d.y + c.y * d.dy;
		        c.dx *= d.dx;
		        c.dy *= d.dy;
		        c.parent = d;
		        layout(c);
		      });
		    }
		  }
		
		  function display(d) {
		    grandparent
		        .datum(d.parent)
		        .on("click", transition)
		      .select("text")
		        .text(name(d));
		
		    var g1 = svg.insert("g", ".grandparent")
		        .datum(d)
		        .attr("class", "depth");
		
		    var g = g1.selectAll("g")
		        .data(d._children)
		      .enter().append("g");
		
		    g.filter(function(d) { return d._children; })
		        .classed("children", true)
		        .on("click", transition);
		
		    var children = g.selectAll(".child")
		        .data(function(d) { return d._children || [d]; })
		      .enter().append("g");
		
		    children.append("rect")
		        .attr("class", "child")
		        .call(rect)
		      .append("title")
		        .text(function(d) { return d.key + " (" + formatNumber(d.value) + ")"; });
		    children.append("text")
		        .attr("class", "ctext")
		        .text(function(d) { return d.key; })
		        .call(text2);
		
		    g.append("rect")
		        .attr("class", "parent")
		        .call(rect);
		
		    var t = g.append("text")
		        .attr("class", "ptext")
		        .attr("dy", ".75em")
		
		    t.append("tspan")
		        .text(function(d) { return d.key; });
		    t.append("tspan")
		        .attr("dy", "1.0em")
		        .text(function(d) { return formatNumber(d.value); });
		    t.call(text);
		
		    g.selectAll("rect")
		        .style("fill", function(d) { return color(d.key); });
		
		    function transition(d) {
		      if (transitioning || !d) return;
		      transitioning = true;
		
		      var g2 = display(d),
		          t1 = g1.transition().duration(750),
		          t2 = g2.transition().duration(750);
		
		      // Update the domain only after entering new elements.
		      x.domain([d.x, d.x + d.dx]);
		      y.domain([d.y, d.y + d.dy]);
		
		      // Enable anti-aliasing during the transition.
		      svg.style("shape-rendering", null);
		
		      // Draw child nodes on top of parent nodes.
		      svg.selectAll(".depth").sort(function(a, b) { return a.depth - b.depth; });
		
		      // Fade-in entering text.
		      g2.selectAll("text").style("fill-opacity", 0);
		
		      // Transition to the new view.
		      t1.selectAll(".ptext").call(text).style("fill-opacity", 0);
		      t1.selectAll(".ctext").call(text2).style("fill-opacity", 0);
		      t2.selectAll(".ptext").call(text).style("fill-opacity", 1);
		      t2.selectAll(".ctext").call(text2).style("fill-opacity", 1);
		      t1.selectAll("rect").call(rect);
		      t2.selectAll("rect").call(rect);
		
		      // Remove the old node when the transition is finished.
		      t1.remove().each("end", function() {
		        svg.style("shape-rendering", "crispEdges");
		        transitioning = false;
		      });
		    }
		
		    return g;
		  }
		
		  function text(text) {
		    text.selectAll("tspan")
		        .attr("x", function(d) { return x(d.x) + 6; })
		    text.attr("x", function(d) { return x(d.x) + 6; })
		        .attr("y", function(d) { return y(d.y) + 6; })
		        .style("opacity", function(d) { return this.getComputedTextLength() < x(d.x + d.dx) - x(d.x) ? 1 : 0; });
		  }
		
		  function text2(text) {
		    text.attr("x", function(d) { return x(d.x + d.dx) - this.getComputedTextLength() - 6; })
		        .attr("y", function(d) { return y(d.y + d.dy) - 6; })
		        .style("opacity", function(d) { return this.getComputedTextLength() < x(d.x + d.dx) - x(d.x) ? 1 : 0; });
		  }
		
		  function rect(rect) {
		    rect.attr("x", function(d) { return x(d.x); })
		        .attr("y", function(d) { return y(d.y); })
		        .attr("width", function(d) { return x(d.x + d.dx) - x(d.x); })
		        .attr("height", function(d) { return y(d.y + d.dy) - y(d.y); });
		  }
		
		  function name(d) {
		    return d.parent
		        ? name(d.parent) + " / " + d.key + " (" + formatNumber(d.value) + ")"
		        : d.key + " (" + formatNumber(d.value) + ")";
		  }
		}
		
		if (window.location.hash === "") {
		    d3.json("${pageContext.request.contextPath}/static/countries.json", function(err, res) {
		        if (!err) {
		            console.log(res);
		            var data = d3.nest().key(function(d) { return d.region; }).key(function(d) { return d.subregion; }).entries(res);
		            main({title: ""}, {key: "공공데이터 포털 분류", values: data});
		        }
		    });
		}
	</script> -->
</body>
</html>