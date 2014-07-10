package fixer;


import javassist.*;

public class Main {

	static public String makeFieldString(CtClass cc, String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append("{Object[] _Args23 = $args; System.out.println(\"==>");
		sb.append(methodName);
		sb.append(": \"");
		for (CtField cf : cc.getDeclaredFields()) {
			sb.append(" + " + cf.getName() + " + \" \"");
		}
		sb.append(");");
		sb.append("for (int i = 0; i<_Args23.length; i++) System.out.println(\"> \"+_Args23[i]);");
		sb.append("System.out.println(\"<== \"+$_);");
		sb.append("};");
		return sb.toString();
	}

	public static void main(String[] args) {
		try {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = null;
		for (String cname : args) {
			cc = pool.get(cname);
			System.out.println("==== Patching " + cname + " ====");
			System.out.println("Added code:"
					+ Main.makeFieldString(cc, "<methodname>"));
			CtBehavior[] ctb = cc.getDeclaredBehaviors();
			for (CtBehavior ctMethod : ctb) {
				String name = ctMethod.getLongName();
				System.out.println("Patching " + name + " "
						+ ctMethod.getSignature());
				try {
					ctMethod.insertAfter(Main.makeFieldString(cc, name));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			CtConstructor[] ccs = cc.getDeclaredConstructors();
			cc.writeFile("tmp");
			cc.defrost();
			cc.detach();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
