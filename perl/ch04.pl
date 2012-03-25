#!/usr/bin/perl

use strict;
use LWP;
use XML::XPath;
use Encode;

# Create the user agent.
my $ua = LWP::UserAgent->new;

my $base_uri = 'http://localhost:8080/teams';

# GET teams?name=MarxBrothers
#my $request = $base_uri . '?name=BurnsAndAllen';
#send_GET($request);

#$base_uri = $base_uri;
send_POST($base_uri);


sub send_GET {
    my ($uri, $qs_flag) = @_;

    # Send the request and get the response.
    my $req = HTTP::Request->new(GET => $uri);
    my $res = $ua->request($req);

    # Check for errors.
    if ($res->is_success) {
        parse_GET($res->content, $qs_flag); # Process raw XML on success
    }
    else {
        print $res->status_line, "\n";      # Print error code on failure
    }
}

# Print raw XML and the elements of interest.
sub parse_GET {
    my ($raw_xml) = @_;
  #  print "\nThe raw XML response is:\n$raw_xml\n;;;\n";

    # For all teams, extract and print out their names and members
    my $xp = XML::XPath->new(xml => $raw_xml);
    foreach my $node ($xp->find('//object/void/string')->get_nodelist) {
        print $node->string_value, "\n";
    }
}


sub send_POST {
    my ($uri) = @_;

    my $xml = <<EOS;
      <create_team>
         <name>SmothersBrothers</name>
         <player>
           <name>Thomas</name>
           <nickname>Tom</nickname>
         </player>
         <player>
           <name>Richard</name>
           <nickname>Dickie</nickname>
         </player>
      </create_team>
EOS
    # Send request and capture response.
    my $bytes = encode('iso-8859-1', $xml); # encoding is Latin-1
    my $req = HTTP::Request->new(POST => $uri, ['Cargo' => $bytes]);
    my $res = $ua->request($req);

    # Check for errors.
    if ($res->is_success) {
        parse_SIMPLE("POST", $res->content); # Process raw XML on success
    }
    else {
        print $res->status_line, "\n";        # Print error code on failure
    }
}

sub parse_SIMPLE {
    my $verb = shift;
    my $raw_xml = shift;
    print "\nResponse on $verb: \n$raw_xml;;;\n";
}     

