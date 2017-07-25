import org.junit.Test;

public class GraphTest {

	@Test
	public void test() {
		// build graph
		Graph<Person> graph=new Graph<Person>();
		Node<Person> tyler= new Node<Person>(new Person("Tyler"));
		Node<Person> holly= new Node<Person>(new Person("Holly"));
		Node<Person> linda= new Node<Person>(new Person("Linda"));
		Node<Person> sneha= new Node<Person>(new Person("Sneha"));
		Node<Person> vincent= new Node<Person>(new Person("Vincent"));
		Node<Person> henry= new Node<Person>(new Person("Henry"));
		Node<Person> jeremy= new Node<Person> (new Person("Jeremy"));
		Node<Person> sophia= new Node<Person>(new Person("Sophia"));
		Node<Person> sam= new Node<Person>(new Person("Sam"));
		Node<Person> emma= new Node<Person>(new Person("Emma"));
		Node<Person> anna= new Node<Person>(new Person("Anna"));
		Node<Person> valentina= new Node<Person>(new Person("Valentina"));
		Node<Person> spencer= new Node<Person>(new Person("Spencer"));
		Node<Person> joey= new Node<Person>(new Person("Joey"));
		Node<Person> william= new Node<Person>(new Person("William"));
		Node<Person> jackson= new Node<Person>(new Person("Jackson"));
		Node<Person> molly= new Node<Person>(new Person("Molly"));
		ArrayList<Edge<Person>> t= new ArrayList<Edge<Person>>();
		t.add(new Edge<Person>(tyler,spencer));
		t.add(new Edge<Person>(tyler,valentina));
		t.add(new Edge<Person>(tyler,linda));
		t.add(new Edge<Person>(tyler,william));
		tyler.setEdges(t);
		ArrayList<Edge<Person>> h= new ArrayList<Edge<Person>>();
		h.add(new Edge<Person>(holly,tyler));
		h.add(new Edge<Person>(holly,spencer));
		h.add(new Edge<Person>(holly,henry));
		holly.setEdges(h);
		ArrayList<Edge<Person>> l= new ArrayList<Edge<Person>>();
		l.add(new Edge<Person>(linda,jeremy));
		l.add(new Edge<Person>(linda,william));
		l.add(new Edge<Person>(linda,valentina));
		l.add(new Edge<Person>(linda,sophia));
		linda.setEdges(l);
		ArrayList<Edge<Person>> sn= new ArrayList<Edge<Person>>();
		sn.add(new Edge<Person>(sneha,henry));
		sn.add(new Edge<Person>(sneha,emma));
		sneha.setEdges(sn);
		ArrayList<Edge<Person>> vin= new ArrayList<Edge<Person>>();
		vin.add(new Edge<Person>(vincent,joey));
		vin.add(new Edge<Person>(vincent, holly));
		vincent.setEdges(vin);
		ArrayList<Edge<Person>> hen= new ArrayList<Edge<Person>>();
		hen.add(new Edge<Person>(henry,sam));
		hen.add(new Edge<Person>(henry,spencer));
		henry.setEdges(hen);
		ArrayList<Edge<Person>> j= new ArrayList<Edge<Person>>();
		j.add(new Edge<Person>(jeremy,linda));
		j.add(new Edge<Person>(jeremy,sophia));
		jeremy.setEdges(j);
		ArrayList<Edge<Person>> so= new ArrayList<Edge<Person>>();
		so.add(new Edge<Person>(sophia,linda));
		so.add(new Edge<Person>(sophia,jackson));
		so.add(new Edge<Person>(sophia,william));
		sophia.setEdges(so);
		ArrayList<Edge<Person>> sa= new ArrayList<Edge<Person>>();
		sa.add(new Edge<Person>(sam,emma));
		sa.add(new Edge<Person>(sam,joey));
		sam.setEdges(sa);
		ArrayList<Edge<Person>> em= new ArrayList<Edge<Person>>();
		em.add(new Edge<Person>(emma,sneha));
		em.add(new Edge<Person>(emma,sam));
		emma.setEdges(em);
		ArrayList<Edge<Person>> a= new ArrayList<Edge<Person>>();
		a.add(new Edge<Person>(anna,molly));
		a.add(new Edge<Person>(anna, valentina));
		anna.setEdges(a);
		ArrayList<Edge<Person>> va= new ArrayList<Edge<Person>>();
		va.add(new Edge<Person>(valentina,anna));
		va.add(new Edge<Person>(valentina,molly));
		valentina.setEdges(va);
		ArrayList<Edge<Person>> sp= new ArrayList<Edge<Person>>();
		sp.add(new Edge<Person>(spencer,henry));
		sp.add(new Edge<Person>(spencer,tyler));
		spencer.setEdges(sp);
		ArrayList<Edge<Person>> jo= new ArrayList<Edge<Person>>();
		jo.add(new Edge<Person>(joey,spencer));
		jo.add(new Edge<Person>(joey,sam));
		joey.setEdges(jo);
		ArrayList<Edge<Person>> w= new ArrayList<Edge<Person>>();
		w.add(new Edge<Person>(william,linda));
		w.add(new Edge<Person>(william,joey));
		william.setEdges(w);
		ArrayList<Edge<Person>> ja= new ArrayList<Edge<Person>>();
		ja.add(new Edge<Person>(jackson,william));
		ja.add(new Edge<Person>(jackson,linda));
		ja.add(new Edge<Person>(jackson,vincent));
		jackson.setEdges(ja);
		ArrayList<Edge<Person>> mo= new ArrayList<Edge<Person>>();
		mo.add(new Edge<Person>(molly,anna));
		molly.setEdges(mo);
		graph.population.add(tyler);
		graph.population.add(holly);
		graph.population.add(linda);
		graph.population.add(sneha);
		graph.population.add(vincent);
		graph.population.add(henry);
		graph.population.add(jeremy);
		graph.population.add(sophia);
		graph.population.add(sam);
		graph.population.add(emma);
		graph.population.add(anna);
		graph.population.add(valentina);
		graph.population.add(spencer);
		graph.population.add(joey);
		graph.population.add(william);
		graph.population.add(jackson);
		graph.population.add(molly);
		tyler.setKarma();
		tyler.adjustWeight();
		holly.setKarma();
		holly.adjustWeight();
		linda.setKarma();
		linda.adjustWeight();
		sneha.setKarma();
		sneha.adjustWeight();
		vincent.setKarma();
		vincent.adjustWeight();
		henry.setKarma();
		henry.adjustWeight();
		jeremy.setKarma();
		jeremy.adjustWeight();
		sophia.setKarma();
		sophia.adjustWeight();
		sam.setKarma();
		sam.adjustWeight();
		emma.setKarma();
		emma.adjustWeight();
		anna.setKarma();
		anna.adjustWeight();
		valentina.setKarma();
		valentina.adjustWeight();
		spencer.setKarma();
		spencer.adjustWeight();
		joey.setKarma();
		joey.adjustWeight();
		william.setKarma();
		william.adjustWeight();
		jackson.setKarma();
		jackson.adjustWeight();
		molly.setKarma();
		molly.adjustWeight();
		Agency agency= new Agency();
		agency.employee.add(holly); // add employees
		agency.employee.add(valentina);

		// testing
		
		// make friends
		graph.makeFriends(agency.employee.get(1), graph.population.get(12));// can't make friends because person is unreachable 
		
		graph.makeFriends(agency.employee.get(0), graph.population.get(3)); // success
		
		Cluster<Person> cluster= new Cluster<Person>(); // identify clusters based on current friendship
		cluster.displayClusters(graph.population);
	}

}
