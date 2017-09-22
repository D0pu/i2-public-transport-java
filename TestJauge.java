class TestJauge {

    public static void main (String[] args) {

	boolean estMisAssertion = false; 
	assert estMisAssertion = true; 
	if (!estMisAssertion) { 
	    System.out.println("Execution impossible sans l'option -ea"); 
	    return;
	}      
	
	testDansIntervalle();
	testSuperieurIntervalle();
	testInferieurIntervalle();
	testRemplissage();
	
	
	System.out.println("Tests terminées");
    }
       
    public void testDansIntervalle() {
	Jauge maJauge = new Jauge(67899, 100);
	
	assert maJauge.estRouge() == false : "estRouge() != false";
	assert maJauge.estVert() == true : "estVert() != true";
    }

    public void testSuperieurIntervalle() {
	Jauge maJauge = new Jauge(242, 250);
	
	assert maJauge.estRouge() == true : "estRouge() != true";
	assert maJauge.estVert() == false : "estVert() != false";
    }

    public void testInferieurIntervalle() {
	Jauge maJauge = new Jauge(242, -50);
	
	assert maJauge.estRouge() == true : "estRouge() != true";
	assert maJauge.estVert() == false : "estVert() != false";
    }
    
    public void testRemplissage() {
	Jauge maJauge = new Jauge(20, 10);
	
	for (int i = 10; i < 20; i++) {
	    assert maJauge.estRouge() == false : "estRouge() != false";
	    assert maJauge.estVert() == true : "estVert() != true";
	    maJauge.incrementer();
	}
	for (int i = 20; i < 30; i++) {
	    assert maJauge.estVert() == false : "estVert() != false";
	    assert maJauge.estRouge() == true : "estRouge() != true";
	    maJauge.incrementer();
	}
    }
}
