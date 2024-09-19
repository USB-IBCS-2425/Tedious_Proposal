class Enclosure {

	String name;
	String animals;
	int numpeacock;
	boolean open;

	public Enclosure(String name,String animals,int numpeacock,boolean open ) {
		this.name = name;
		this.animals = animals;
		this.numpeacock = numpeacock;
		this.open = open;
	}

	public String getname() {
		return name;
	}

	public Boolean isOpen () {
		return open; 
	}

	public int getnumanimal () {
		return numpeacock;
	}

	public void addanimal(peacock n ) {
	
		animals = animals + n.getname();

	
	}

	public String getanimals() {
		return animals;
	}

	public static void main(String[] args) {
		Enclosure theEnclosure = new Enclosure("Peacock Enclosure","peacock", 4, true);
		peacock peacock1 = new peacock("Tom", "Peacock", 4, true);
		peacock peacock2 = new peacock("Ben", "Peacock", 2, true);
		peacock peacock3 = new peacock("Jefferson", "Peacock", 3, false);
		peacock peacock4 = new peacock("Den", "Peacock", 4, true);

		System.out.println(theEnclosure.getname());
		System.out.println(theEnclosure.getanimals());
		System.out.println(theEnclosure.getnumanimal());
		System.out.println(theEnclosure.isOpen());


		theEnclosure.addanimal(peacock1);
		theEnclosure.addanimal(peacock2);
		theEnclosure.addanimal(peacock3);
		theEnclosure.addanimal(peacock4);

		System.out.println(theEnclosure.getname());
		System.out.println(theEnclosure.getanimals());
		System.out.println(theEnclosure.getnumanimal());
		System.out.println(theEnclosure.isOpen());

	}

	






		



}
