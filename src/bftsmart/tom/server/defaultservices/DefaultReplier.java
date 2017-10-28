/**
Copyright (c) 2007-2013 Alysson Bessani, Eduardo Alchieri, Paulo Sousa, and the authors indicated in the @author tags

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package bftsmart.tom.server.defaultservices;

import bftsmart.tom.MessageContext;
import bftsmart.tom.ReplicaContext;
import bftsmart.tom.core.messages.TOMMessage;
import bftsmart.tom.server.Replier;

/**
 *
 * @author miguel
 */
public class DefaultReplier implements Replier{

    private ReplicaContext rc;
    
    public DefaultReplier() {
    	System.out.println("---- NEW DefaultReplier");
    }
    
    @Override
    public void manageReply(TOMMessage request, MessageContext msgCtx) {
    	try {
            rc.getServerCommunicationSystem().send(new int[]{request.getSender()}, request.reply);
    	}
    	catch(NullPointerException npe) {
        	System.out.println("--DefaultReplier rc: " + rc);
        	System.out.println("--DefaultReplier rc.scs: " + rc.getServerCommunicationSystem());
        	System.out.println("--DefaultReplier request: " + request);
        	System.out.println("--DefaultReplier sender: " + request.getSender());
        	System.out.println("--DefaultReplier reply: " + request.reply);
    	}
    }

    @Override
    public void setReplicaContext(ReplicaContext rc) {
    	System.out.println("---SETTING ReplicaContext: " + rc);
        this.rc = rc;
    }
    
}
