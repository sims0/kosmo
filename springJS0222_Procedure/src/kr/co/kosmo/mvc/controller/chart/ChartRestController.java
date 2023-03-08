package kr.co.kosmo.mvc.controller.chart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

//@Controller ������ �����̳ʤӰ� Model�� �����ؼ�
// ���� �ý��ۿ����� ViewResolver�� ���ؼ� ����
//<!-- ViewŸ�� => viewResolver ���� /WEB-INF/views/[hello].jsp class => InternalResourceViewResolver -->
//View�� ������ forward������� �̵��Ѵ�.
//@RestController -> CustomView�� ����ؼ� ������ View ��, JSP�� ������� �ʰ� �����͸� ������ �� �ֱ� ������
// �ַ� JSON���� response �� �� �ַ� �����
@RestController
public class ChartRestController {
// �ش� ��û�� ���� ���� View�� ��ȯ���� ���� �����ؼ� ����ó���� ���ش�.
	@Autowired
	public MemberDaoInter memberDaoInter;

	
	//produces = "text/html;charset=euc-kr" => Context-Type�� �����ϴ� �Ӽ�
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String veiwMessage() {
		return "�ȳ��ϼ���";
	}
	
	//Json ObjectType -> javaScript Object
	@RequestMapping(value = "/deptJsonView1", produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		
		try {
			MemberDTO vo = memberDaoInter.jsonDemo(id);
			System.out.println("id=>"+id);
			return vo;
		} catch (Exception e) {
			MemberDTO vo = new MemberDTO();
			vo.setName("����");
			System.out.println("name=>"+vo.getName());
			return vo;
		}
		
		/*
		System.out.println("id=>"+id);
		MemberDTO vo = new MemberDTO();
		vo.setName("�̺�");
		vo.setNum(1);
		vo.setAge(19);
		vo.setGender("����");
		vo.setId("spring2");
		vo.setPwd("123");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		//���Ȯ��
		//{"num":1,"age":19,"id":"Spring2","name":"�̺�",
		//"gender":"����","pwd":"123","mdate":"2023-01-18"}
		return vo;
		*/
	}
	
	//��������1 : ȸ�� ��ü�� ����ϴ� JsonView�� ����ÿ�
	@GetMapping(value = "deptJsonView2", produces = "application/json;charset=utf-8")
	public List<MemberDTO> jsonObjectDemolist() {
		List<MemberDTO> list = memberDaoInter.jsonDemolist();
		return list;
	}
	
	//�������� 2: ȸ�� ��ü�� ����ϴ� js ����¡�� ��  JsonView�� ����ÿ�
	//public PagingDTO 

	
}
