package site.helloyuan.springboot01.models;

public class Hello {
	private final long id;
	private final String content;

	public Hello(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

    @Override
    public String toString() {
        return "Hello [content=" + content + ", id=" + id + "]";
    }
}
