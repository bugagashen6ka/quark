package fixer;


import javassist.*;

public class Main {

	static public String makeEndString(CtClass cc, String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("System.out.println(\"==> return ");
		sb.append(methodName);
		sb.append(" state : \"");
		for (CtField cf : cc.getDeclaredFields()) {
			String fname = cf.getName();
			if (!fname.equals("groups")) {
				sb.append(" + " + cf.getName() + " + \" | \"");
			}
		}
		sb.append(");");
		sb.append("System.out.println(\"<== \"+$_);");
		sb.append("};");
		return sb.toString();
	}
	static public String makeStartString(CtClass cc, String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("System.out.println(\"==> call ");
		sb.append(methodName);
		sb.append("\");");
		sb.append("Object[] _Args23 = $args;");
		sb.append("for (int i = 0; i<_Args23.length; i++) System.out.println(\"> \"+_Args23[i]);");
		sb.append("};");
		return sb.toString();
	}
	public static boolean isSafe(CtBehavior cb) {
		try {
			for (CtClass ccp : cb.getParameterTypes()) {
				if (ccp.getName().equals("java.util.Set")) return false;
			}
		} catch (NotFoundException e) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		try {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = null;
		for (String cname : args) {
			cc = pool.get(cname);
			System.out.println("==== Patching " + cname + " ====");
			System.out.println("Added start code: "
					+ Main.makeStartString(cc, "<methodname>"));
			System.out.println("Added end code: "
					+ Main.makeEndString(cc, "<methodname>"));
			CtBehavior[] ctb = cc.getDeclaredBehaviors();
			for (CtBehavior b : ctb) {
				String name = b.getLongName();
				try {
					if(Main.isSafe(b)) {
						System.out.println("Patching " + name + " "
								+ b.getSignature());
						b.insertBefore(Main.makeStartString(cc, name));
						b.insertAfter(Main.makeEndString(cc, name));						
					} else {
						System.out.println("Not patching " + name + " "
								+ b.getSignature());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			cc.writeFile("tmp");
			cc.defrost();
			cc.detach();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
