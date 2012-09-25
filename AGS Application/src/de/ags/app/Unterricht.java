package de.ags.app;

public class Unterricht {
	public String name;
	public String abbreviation;
	public String region;
	public String resourceId;

	public Unterricht() {
		// TODO Auto-generated constructor stub
	}

	public Unterricht(String name, String abbreviation, String region,
			String resourceFilePath) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.region = region;
		this.resourceId = resourceFilePath;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
