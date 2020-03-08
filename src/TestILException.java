
public class TestILException {
	public TestILException() {
		// TODO Auto-generated constructor stub
	}
	
	void _test (int n) throws ILException {
		if (n<=0) {
			throw new ILException("n doit etre non null positif");
		}
		//return ;
	}
}
