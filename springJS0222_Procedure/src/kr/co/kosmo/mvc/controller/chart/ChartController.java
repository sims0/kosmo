package kr.co.kosmo.mvc.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mychart")
public class ChartController {
	
	
	@GetMapping(value = "/deptJsonDemo")
	public String deptJsonDemo() {
		return "chart/deptJsonDemo";
	}
	
	@GetMapping(value = "/memberListJsonDemo")
	public String memberListJsonDemo() {
		return "chart/memberListJsonDemo";
	}
	
	@GetMapping(value = "/bar")
	public String student() {
		return "chart/chartBar";
	}
	
	@GetMapping(value = "/donut")
	public String chartDonut() {
		return "chart/chartDonut";
	}
	@GetMapping(value = "/donut2")
	public String chartDonut2() {
		return "chart/chartDonut2";
	}
	
	@GetMapping(value = "/surveyDonutchartAjax")
	public String chartAjax() {
		return "chart/surveyChartAjax";
	}
	
	
	@GetMapping(value = "/surveyChartAjaxTitle")
	public String surveyClientRes(Model model, int num) {
		model.addAttribute("num",num);
		return "chart/surveyChartAjaxTitle";
	}
	
	
	
}
