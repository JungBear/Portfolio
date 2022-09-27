import java.util.ArrayList;

public class Player {
	private String name;
	final int maxPokemonNumber = 4;
	ArrayList<pokemon> myPokemonList = new ArrayList<>();
	int presentPokemonNumber = myPokemonList.size();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<pokemon> getMyPokemonList() {
		return myPokemonList;
	}

	public void setMyPokemonList(ArrayList<pokemon> myPokemonList) {
		this.myPokemonList = myPokemonList;
	}
}