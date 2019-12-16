package deb;

public class ChangelogEntry {
	public enum Stability {
		STABLE, UNSTABLE
	}

	public enum Urgency {
		LOW, MEDIUM, HIGH, STONED
	}

	String packg;

	String version;

	String desc;

	String publisher;

	String mail;

	String timestamp;

	Stability stab;

	Urgency urg;

	public ChangelogEntry(String packg, String version, String desc, String publisher, String mail, String timestamp,
			Stability stab, Urgency urg) {
		this.packg = packg;
		this.version = version;
		this.desc = desc;
		this.publisher = publisher;
		this.mail = mail;
		this.timestamp = timestamp;
		this.stab = stab;
		this.urg = urg;
	}

	@Override
	public String toString() {
		// String example = "solfac (4.0) stable; urgency=medium\n" + " \n" + " * Added
		// the md5 files for mdsum\n" + " \n"
		// + " -- Facundo Solowinski <a17facsolmez@iam.cat> Wed, 17 Oct 2018 15:57:35
		// +0100";

		String s = packg + " (" + version + ") " + stab + "; urgency=" + urg + "\n" +

				"\n* " + desc + "\n" +

				"\n-- " + publisher + " <" + mail + "> " + timestamp;

		return s;
	}

}
